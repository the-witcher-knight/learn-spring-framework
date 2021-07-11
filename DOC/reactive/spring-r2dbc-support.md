# R2DBC support

R2DBC chứa nhiều tính năng:

- Hỗ trợ cấu hình Spring với các class `@Configuration` dựa trên Java cho phiên bản trình điều khiễn R2DBC.

- `R2dbcEntitiyTemplate` làm lớp trung tâm cho các hoạt động ràng buộc thực thể giúp tăng năng suất khi thực hiện các hoạt động R2DBC phổ biến với ánh xạ đối tượng tích hợp giữa các hàng và POJO.

- Ánh xạ đối tưỡng giàu tính năng được tích hợp với `Spring's Conversion Service`.

- Metadata ánh xạ dựa trên `annotation` có thể mở rộng để hỗ trợ các định dạng siêu dữ liệu khác.

- Tự động implement các interface Repository, bao gồm hổ trợ các phương thức query tùy chỉnh.

Ví dụ cơ bản sử dụng `r2dbcEntityTemplate`

ta có 1 bản person như thế này

```sql
CREATE TABLE person
  (id VARCHAR(255) PRIMARY KEY,
   name VARCHAR(255),
   age INT);
```

ta tạo một entity tương ứng cho nó

```java
public class Person {

  private final String id;
  private final String name;
  private final int age;

  public Person(String id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
  }
}
```

Ta viết một class application và hàm main sử dụng `r2dbcEntityTemplate` để tạo bảng và insert, select

```java
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reactor.test.StepVerifier;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

public class R2dbcApp {

  private static final Log log = LogFactory.getLog(R2dbcApp.class);

  public static void main(String[] args) {

    ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");

    R2dbcEntityTemplate template = new R2dbcEntityTemplate(connectionFactory);

    template.getDatabaseClient().sql("CREATE TABLE person" +
        "(id VARCHAR(255) PRIMARY KEY," +
        "name VARCHAR(255)," +
        "age INT)")
      .fetch()
      .rowsUpdated()
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();

    template.insert(Person.class)
      .using(new Person("joe", "Joe", 34))
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();

    template.select(Person.class)
      .first()
      .doOnNext(it -> log.info(it))
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();
  }
}
```

Trong ví dụ trên, ta cần chú ý:

- Có thể tạo 1 thể hiện của central helper class trong Spring Data R2DBC (R2dbcEntityTemplate) bằng cách sử dụng đối tượng `io.r2dbc.spi.ConnectionFactory`

- Trình mapper hoạt động dựa trên các đối tượng POJO tiêu chuẩn mà không cần bất kì metadata bổ sung nào (có thể thêm tuy chọn [xem thêm](https://docs.spring.io/spring-data/r2dbc/docs/1.3.2/reference/html/#mapping))

- Các quy ước mapping có th sửa dụng quyền access field. class `Person` chỉ có các hàm getters.

- Nếu các tham số trong constructor có tên trùng với tên cột của hàng được lưu trữ chúng được sử dụng để instantiate đối tượng.

## R2dbcEntityOperations Data Access API

`R2dbcEntityOperation` cung cấp các phương thức hướng thực thể như là querying, inserting, updating, và delete.

Ví dụ về `Mono`:

```Java
Person person = new Person("Yến", "Lùn");

Mono<Person> saved = template.insert(person);
Mono<Person> loaded = template.selectOne(query(where("firstname").is("Yến")), Person.class);
```

`Mono<T>insert(T đối tượng cần save)`: Thêm 1 đổi tượng vào bảng mặc định.
`Mono<T>update(T đổi tượng cần lưu`: Thêm 1 đối tượng vào bảng(tương tự insert).

Tên bảng có thể được tùy chỉnh bằng cách sử dụng fluent API.

Ví dụ vè `Flux`:

```Java
Flux<Person> loaded = template.select(
  query(
    where("firstname").id("Yến")
  ), Person.class
);
```

## Fluent API

```Java
Flux<Person> people = template.select(Person.class).all();
```

- Sử dụng `Person` với phương thức `select(...)` map bảng với đối tượng trả về `Person`.

- Fetch `all()` hàng trả về 1 `Flux<Person>` mà không giới hạn kết quả.

Ví dụ về 1 câu truy vấn phức tạp:

```Java
// Select từ 1 bảng bởi tên trả về kết quả hàng bằng cách sử dụng
// domain type Person
Mono<Person> first = template.select(Person.class)
  .from("other_person")
  .matching(
    query(
      // Truy vấn dựa trên cột firstname và lastname
      where("firstname")
      .is("Yến")
      .and("lastname")
      .in("Lùn", "Cute")
    )
    // ORDER BY để sắp xếp
    .sort(by(desc("id")))
  )
  .one(); //Chọn 1 kết quả, chỉ tìm nạp 1 kết quả duy nhất

// Mono sẽ tạo ra 1 {IncorrectResultSizeDataAccessException} nếu
// truy vấn mang lại nhiều hơn 1 kết quả
```

Có thẻ truy xuất 1 hoặc nhiều thực thể thông qua các kết thúc sau:

- `first()`: Chỉ sử dụng hàng đầu tiên trả về 1 `Mono`. Nếu truy vấn không trả về kết quả thì `Mono` complete không tạo ra đối tượng.

- `one()`: Chỉ chính xác 1 hàng trả về 1 `Mono`. Khi `Mono` complete mà không tạo ra 1 đối tượng nếu câu truy vấn không trả về kết quả nào hết. Nếu câu truy vấn trả về hơn 1 hàng, `Mono` hoàn thành và trả về `IncorrectResultSizeDataAccessException`.

- `all()`: sử dụng tất cả các hàng trả về 1 `Flux`.

- `count()`: đếm tất cả các hàng và trả về `Mono<Long>`.

- `exists()`: kiểm tra có trả về bất cứ hàng nào không trả về `Mono<Boolean>`.

Sử dụng `select()` để thực hiện các truy vấn `SELECT`. Để cải thiện khả năng đọc, có thể sử dụng static import giúp tránh sử dụng từ khóa `new` để tạo instances `Criteria`.

## Các phương thức cho lớp `Criteria`

Lớp `Criteria` cung cấp các phương thức sau, tương ứng với các toán tử SQL.

- `Criteria` **and** `(String column)`: thêm `Criteria` với `property` được chỉ định vào `Criteria` hiện tại và trả về cái mới được tạo.

- `Criteria` **or** `(String column)`: thêm 1 `Criteria` theo chuỗi với `property` được chỉ định vào `Criteria` hiện tại và trả về cái mới được tạo.

- `Criteria` **greaterThan** `(Object o)`: Tạo 1 tiêu chí bằng cách sử dụng toán tử `>`.

- `Criteria` **greaterThanOrEquals** `(Object o)`: `>=`.

- `Criteria` **in** `(Object o)`: Tạo 1 tiêu chí bằng cách sử dụng `in` cho 1 đối số varargs.

- `Criteria` **in** `Collection<?> collection`: Tạo 1 tiêu chí bằng cách sử dụng `IN` operator sử dụng 1 collection.

- `Criteria` **is** `(Object o)`: Tạo 1 tiêu chí bằng cách sử dụng matching(property = value).

tương tự cho `isNull(), isNotNull(), lessThan(Object o), lessThanOrEquals(Object o), like(Object o), not(Object o), notIn(Object o), notIn(Collection<?> collection)`

Có thể sử dụng `Criteria` với các truy vấn `SELECT`, `UPDATE`, và `DELETE`.

Dùng `insert()` để thêm data.

```Java
Mono<Person> inserter = template.insert(Person.class)
  .using(new Person("Yến", "Lùn"));
```

Ngoài ra có thể cung cấp `Publisher` để chạy một lường các câu lệnh `INSERT`.
Phương pháp này trích xuất tất cả các giá trị `non-null` và insert chúng.

Sử dụng `update()` để update các hàng.

```Java
Person modified = ...

// Update `Person` và chấp nhận ánh xạ dựa trên ánh xạ metadata.
Mono<Integer> updater = template.update(Person.class)
  .inTable("other_table") // Đặt một tên bảng khác
  .matching(query(
    where("firstname").is("Yến") // chỉ định truy vấn where
  ))
  .apply(update("age", 42)); // update age thành 42 và trả về hàng bị ảnh hưởng.
```

Sử dụng `delete()` để update các hàng.

```Java
// Xóa 1 đối tượng và cho phép ánh xạ dự trên
Mono<Integer> deleter = templte.delete(Person.class)
  .from("other_table") // đặt tên table khác
  .matching(query(
    where("firstname").is("Yến")
  ))
  .all(); // Áp dụng thao tác xóa và trả về tất cả các hàng bị ảnh hưởng.
```