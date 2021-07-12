# Spring R2DBC Repositories

Ví dụ lớp `Person`:

```Java
public class Person {
  @Id
  private Long id;
  private String firstname;
  private string lastname;

  // có thêm getter và setter
}
```

Repository inteface na ná như bên Spring JPA.

```Java
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
```

Để cấu hình R2DBC repository, cần sử dụng chú thích `@EnableR2dbcRepositories`. Nếu không có package nào được cầu hình, infrastructure scan các gói của lớp cấu hình được chú thích.

```Java
@Configuration
@EnableR2dbcRepositories
class ApplicationConfig extends AbstractR2dbcConfiguration {

  @Override
  public ConnectionFactory connectionFactory() {
    return …
  }
}
```

Paging access to Person entities

```Java
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class PersonRepositoryTests {

  @Autowired
  PersonRepository repository;

  @Test
  void readsAllEntitiesCorrectly() {

    repository.findAll()
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();
  }

  @Test
  void readsEntitiesByNameCorrectly() {

    repository.findByFirstname("Hello World")
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();
  }
}
```

## Các phương thức truy vấn

Ví dụ truy vấn

```Java
interface ReactivePersonRepository extends ReactiveSortingRepository<Person, Long> {

  // Tìm tất cả Person bởi firstname
  Flux<Person> findByFirstname(String firstname);                                   

  // Phương thức show 1 truy vấn tất cả people với firstname được phát hành
  // bởi Publisher nhất định 
  Flux<Person> findByFirstname(Publisher<String> firstname);                        

  // Sử dụng `Pageable` để chuyển các tham số bù đắp và sắp xếp vào database
  Flux<Person> findByFirstnameOrderByLastname(String firstname, Pageable pageable); 

  // Tìm duy nhất 1 thực thể
  // nếu trả về IncorrectResultSizeDataAccessException trên các kết quả non-unique
  Mono<Person> findByFirstnameAndLastname(String firstname, String lastname);       

  // Thực thể đầu tiên luôn được phát ra ngay khi truy vấn mang lại nhiều kết quả hơn
  Mono<Person> findFirstByLastname(String lastname);                                

  @Query("SELECT * FROM person WHERE lastname = :lastname")
  Flux<Person> findByLastname(String lastname);                                     

  @Query("SELECT firstname, lastname FROM person WHERE lastname = $1")
  Mono<Person> findFirstByLastname(String lastname);                                
}
```

Bản các keyword hổ trợ

| Keyword                                    | Sample                                    | mô tả                              |
| ------------------------------------------ | ----------------------------------------- | ---------------------------------- |
| After                                      | findByBirthdateAfter(Date date)           | birthdate > date                   |
| GreaterThan                                | findByAgeGreaterThan(int age)             | age > age                          |
| GreaterThanEqual                           | findByAgeGreaterThanEqual(int age)        | age >= age                         |
| Before                                     | findByBirthdateBefore(Date date)          | birthdate < date                   |
| LessThan                                   | findByAgeLessThan(int age)                | age < age                          |
| LessThanEqual                              | findByAgeLessThanEqual(int age)           | age <= age                         |
| Between                                    | findByAgeBetween(int from, int to)        | age BETWEEN from AND to            |
| NotBetween                                 | findByAgeNotBetween(int from, int to)     | age NOT BETWEEN from AND to        |
| In                                         | findByAgeIn(Collection<Integer> ages)     | age IN (age1, age2, ageN)          |
| NotIn                                      | findByAgeNotIn(Collection ages)           | age NOT IN (age1, age2, ageN)      |
| IsNotNull, NotNull                         | findByFirstnameNotNull()                  | firstname IS NOT NULL              |
| IsNull, Null                               | findByFirstnameNull()                     | firstname IS NULL                  |
| Like,<br /> StartingWith,<br /> EndingWith | findByFirstnameLike(String name)          | firstname LIKE name                |
| NotLike, IsNotLike                         | findByFirstnameNotLike(String name)       | firstname NOT LIKE name            |
| Containing on String                       | findByFirstnameContaining(String name)    | firstname LIKE '%' + name +'%'     |
| NotContaining on String                    | findByFirstnameNotContaining(String name) | firstname NOT LIKE '%' + name +'%' |
| (No keyword)                               | findByFirstname(String name)              | firstname = name                   |
| Not                                        | findByFirstnameNot(String name)           | firstname != name                  |
| IsTrue, True                               | findByActiveIsTrue()                      | active IS TRUE                     |
| IsFalse, False                             | findByActiveIsFalse()                     | active IS FALSE                    |

Truy vấn `Delete...By`

```Java
interface ReactivePersonRepository extends ReactiveSortingRepository<Person, String> {

  // Trả về type of Mono<Integer> trả về số hàng bị ảnh hưởng
  Mono<Integer> deleteByLastname(String lastname);            

  // Sử dụng void để xem các hàng đã được xóa thành công hay chưa mà không đưa ra giá trị kết quả
  Mono<Void> deletePersonByLastname(String lastname);         

  // sử dụng boolean báo cáo liệu ít nhất 1 hàng đã bị xóa
  Mono<Boolean> deletePersonByLastname(String lastname);      
}
```

sửa đổi các truy vấn chỉ cần liên kết tham số bằng cách chú thích phương thức truy vấn với `@Modifying`

```Java
@Modifying
@Query("UPDATE person SET firstname = :firstname where lastname = :lastname")
Mono<Integer> setFixedFirstnameFor(String firstname, String lastname);
```

Kết quả của một truy vấn sửa đổi có thể là:

Chỉ có 3 loại `Integer`, `Void`, `Boolean`

Chú thích `@Modifying` chỉ có có hiểu quả khi kết hợp với `@Query`

## Truy vấn với SpEL Expressions

```Java
@Query("SELECT * FROM person WHERE lastname = :#{[0]}")
Flux<Person> findByQueryWithExpression(String lastname);
```

Hổ trợ biểu thức có thể mở rộng thông qua SPI truy vấn:
`org.springframework.data.spel.spi.EvaluationContextExtension`. 

## Truy vấn bằng Example

Spring Date R2DBC cũng cho phép sử dụng Query By Example cho các truy vấn fashion.

```Java
// Tạo 1 đối tượng domain với tiêu chí (các trường rỗng sẽ bị bỏ qua)
Employee employee = new Employee(); 
employee.setName("Frodo");

// Sử dụng  domain object, tạo 1 Example
Example<Employee> example = Example.of(employee); 

// thông qua R2dbcRepository, excute query()
// findOne cho Mono
Flux<Employee> employees = repository.findAll(example); 

// do whatever with the flux
```

Ví dụ: truy vấn bằng cách sử dụng domain. Trong trường hợp này nó sẽ truy vấn dựa trên trường tên của `Employee`, các trường `null` bị bỏ qua.

```Java
Employee employee = new Employee();
employee.setName("Yến");
employee.setRole("ring bearer");

// Tạo 1 custom `ExampleMatcher` để match tất cả các field (sử dụng matchAny()
// để match bất kỳ trường nào)
ExampleMatcher matcher = matching() 
    .withMatcher("name", endsWith()) // Với name field, khớp với phần cuối của chương trình
    .withIncludeNullValues()  // Match với tất cả các cột null (null này khác null trong csdl quan hệ)
    .withIgnorePaths("role"); // bỏ qua trường này

// Cắm  ExampleMatcher tùy chỉnh đầu dò
Example<Employee> example = Example.of(employee, matcher); 

Flux<Employee> employees = repository.findAll(example);

// do whatever with the flux
```

Có thể dùng `withTransform()` đối với bất kỳ thuộc tính nào, cho phép chuyển đổi một thuộc tính trước khi hình thành truy vấn. 
Ví dụ, có thể sử dụng `toUpperCase()` dựa trên chuỗi trước khi truy vấn được tạo.

## Các tùy chọn để phát hiện xem một thực thể có phải là mới trong Spring Data hay không

`@Id` - Property inspection(default): Nếu thuộc tính định danh là null hoặc 0 trong trường hợp là kiểu nguyên thủy, thì thực thể được giả định là mới. Nếu không, nó được cho là không mới.

`@Version` - Property inspection: ...