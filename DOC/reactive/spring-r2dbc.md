# Tổng quan Spring R2DBC

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

