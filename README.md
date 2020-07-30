![](./img/spring-boot.png)

# Learn Spring Boot Framwork
------------------
table of contents

1. [Java cơ bản](#java_basic) 

    1.1. [Tổng quan](#java_overview) 
    
    1.2. [Cú pháp cơ bản](#java_basicsyntax)

    1.3. [Java Object and Class](#java_objnclass)
------------------


![](./img/java-mini-logo.png)

# Java cơ bản <a href="java_basic"></a>

## Tổng quan <a href="java_overview"></a>

Một vài lợi thế chính của Java:

-  **Hướng đối tượng**: Trong Java, mọi thứ đều là đối tượng. Java có thể dễ dàng được mở rộng vì nó dựa trên mô hình đối tượng.

- **Nền tảng độc lập**: Không giống như nhiều ngôn ngữ lập trình khác bao gồm C và C++, khi Java được biên dịch, nó không được biên dịch vào nền tảng máy cụ thể, thay vào đó là mã byte độc ​​lập với nền tảng. Mã byte này được phân phối trên web và được Máy ảo (JVM) giải thích trên bất kỳ nền tảng nào nó đang được chạy.

- **Đơn giản**

- **Bảo mật**: Kỹ thuật xác thực dựa trên mã hóa public-key

- **Kiến trúc trung tính (Architecture-neutral)**: Trình biên dịch Java tạo một định dạng file đối tượng kiến trúc trung tính làm cho mã được biên dịch có thể thực thi trên nhiểu bộ xử lý, với sự hiện diện của Java runtime system.

- **Di động**

- **Mạnh mẽ**

Java được đảm bảo là "Write Once, Run Anywhere".

- **Đa luồng (Multithreaded)**: có thể viết các chương trình có thể chạy đồng thời nhiều tác vụ. Tính năng này có phép thiết kế các phần mềm có thể chạy trơn tru.

- **Diễn tả (Interpreted)**: mã byte Java có thể được diễn tả nhanh chóng sang các hướng dẫn máy và không được lưu ở bất cứ đâu.

- **Hiệu suất cao**

- **Distributed**: Java được thiết kế cho môi trường phân tán trên internet

- **Dynamic**

## Cú pháp cơ bản <a href="java_basicsyntax"></a>

### Chương trình đầu tiên

```java
public class MyFirstJavaProgram {
    /* This is my first java program.
    * This will print 'Hello World' as the output
    */

    public static void main(String []args) {
        System.out.println("Hello World"); // prints Hello World
    }
}
```

> Lưu ý cách đặt tên: class thường đặt in hoa chữ cái đầu MyFirstJavaProgram; tên phương thức thường đặt kiểu myMethodName();

### Định danh Java (Java identifiers)

Cách đặt tên trong Java có những điểm cần lưu ý:
- Tất cả định danh nên được bắt đầu bằng kí tự A-Z, a-z, $ hoặc _
- Sau kí tự đầu tiên thì tổ hợp nào cũng được.
- Không thể dùng từ khóa làm định danh.
- Java có phân biệt chữ hoa chữ thường.

### Java modifiers

Giống các ngôn ngữ khác có thể sửa đổi các class, method,... bằng modifiers. Có 2 loại modifiers:
- Access modifiers: default, public, protect, private.
- Non-Access modifiers: final, abstract, strictfp

### Biến Java

- Local variables
- Class variables (static variables)
- Instance variables (non-static variables)

### Mảng Java

### Java enum

```java
class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM, LARGE }
   FreshJuiceSize size;
}

public class FreshJuiceTest {

   public static void main(String args[]) {
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.MEDIUM ;
      System.out.println("Size: " + juice.size);
   }
}
```

### Java keywords

|###|###|###|###|
|-|-|-|-|
|abstract|assert|boolean|break|
|byte|case|catch|char|
|class|const|continue|default|
|do|double|else|enum|
|extends|final|finally|float|
|for|goto|if|implements|
|import|instanceof|int|interface|
|long|native|new|package|
|private|protected|public|return|
|short|static|strictfp|super|
|switch|synchronized|this|throw|
|throws|transitent|try|void|
|volatile|while||||

### Kế thừa (Inhentitance)

### Interfaces

## Java Object and Class <a href="java_objnclass"></a>

Java là một ngôn ngữ lập trình hướng đồi tượng, Java hỗ trợ những khái niệm cơ bản sau:
- **Polymorphism (đa hình)**
- **Inheritance (kế thừa)**
- **Encapsulation (tính bao đóng)**
- **Abstraction (trừu tượng)**
- **Classes**
- **Objects**
- **Instance**
- **Method**
- **Message Passing**

### Object in Java

Đối tượng phần mềm cũng có trạng thái (state) và hành vi (behavios). Trạng thái của một trường phần mềm được lưu trữ trong trường (fields) và hành vi được thể hiện thông qua các phương thức.

### Classes in Java

Một class là một bản thiết kế (blueprint) mà từ đó một đối tượng được tạo ra.
Ví dụ:

```java
public class Dog {
    String breed;
    int age;
    String color;

    void barking(){

    }

    void hungry(){

    }

    void sleeping(){

    }
}
```

Một class có thể chứa bất kì loại biến sau:
- Local variables: biến trong các phương thức
- Instance variables : biến bên ngoài các phương thức được khởi tạo cùng với class và có thể truy cập từ bất kì phương thức nào.
- Class variables: Giống instance variables nhưng có từ khóa static.

### Constructors

Là một chủ đề quan trọng trong một class, nếu không được viết rõ ràng Java compiler sẻ tạo ra một default constructors cho class.

Mỗi khi một đối tượng mới được tạo, có ít nhất một constructor được gọi. Constructor sẻ được đặt cùng tên với class và mỗi class có thể có nhiều hơn 1 constructor.

Ví dụ:
```java
public class Dog{

    public Dog(String name){
        // Constructor này có một tham số, name
    }
}
```

Java cũng hỗ trợ *Singleton Class* nơi bạn chỉ có thể tạo một đối tượng của 1 class.

### Java - how to use singleton class

Mục đích của singleton class là giới hạn việc tạo đối tượng còn 1.

Vì chỉ có một phiên bản singleton, bất kì instance fields của một singleton sẻ chỉ xảy ra một lần trên mỗi lớp, giống như các trường static. Singleton thường điều khiển việc truy cập vào các tài nguyên, chẳng hạn như kết nối CSDL hoặc sockets.

Ví dụ, nếu bạn chỉ có mỗi một giấy phép (license) cho duy nhất một kết nối tới database hoặc trình điều khiển của bạn gặp sự cố với đa luồng (multithreading), singleton đảm bảo rằng chỉ có duy nhất một kết nối được tạo ra hoặc chỉ có duy nhất một luồng được có thể truy cập kết nối tại một thời điểm.

#### Thực thi singleton

Ví dụ 1:

Cách thực hiện dễ nhất bao gồm 1 private contructor, một field để giử kết quả và một phương thức truy cập static như getInstance().

Private field có thể được chỉ định từ trong 1 static initializer block hoặc đơn giản hơn sử dụng initializer. Phương thức getInstance() (phải public) sau đó chỉ cần trả về thể hiện này.

```java
// File name: Singleton.java
public class Singleton{

    private static Singleton singleton = new Singleton( );

   /* 
    * A private Constructor ngăn chặn bất kỳ lớp nào khác khởi tạo
    */
   private Singleton() { }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
   protected static void demoMethod( ) {
      System.out.println("demoMethod for singleton");
   }
}
```

Ví dụ 2:

```java
public class ClassicSingleton {

   private static ClassicSingleton instance = null;
   private ClassicSingleton() {
      // Exists only to defeat instantiation.
   }

   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }
}
```
Lớp ClassicSingleton sử dụng một kỹ thuật được gọi là khởi tạo lười biếng để tạo ra singleton; kết quả là, cá thể singleton không được tạo cho đến khi phương thức getInstance () được gọi lần đầu tiên. Kỹ thuật này đảm bảo rằng các phiên bản singleton chỉ được tạo khi cần thiết.

### Tạo một đối tượng

Về cơ bản, một đối tượng được tạo ra từ một class. Trong Java, `new` là từ khóa được sử dụng để tạo mới 1 đối tượng.

Dưới đây là 3 bước để tạo 1 đối tượng.
- Declaration
- Instantiation: dùng `new` để tạo mới 1 đối tượng
- Initialization

Ví dụ:

```java
Live Demo
public class Puppy {
   public Puppy(String name) {
      // This constructor has one parameter, name.
      System.out.println("Passed Name is :" + name );
   }

   public static void main(String []args) {
      // dòng lệnh sau tạo 1 đối tượng tên có name = tommy
      Puppy myPuppy = new Puppy( "tommy" );
   }
}
```



----------------------------

----------------------------

# Khái niệm tight-coupling (liên kết ràng buộc) và cách loosely coupled
