![](./img/spring-boot.png)

# Learn Spring Boot Framwork
------------------
table of contents

1. [Java cơ bản](#java_basic) 

    1.1. [Tổng quan](#java_overview) 
    
    1.2. [Cú pháp cơ bản](#java_basicsyntax)

    1.3. [Java Object and Class](#java_objnclass)

    1.4. [Java basic datatype](#java_basicdatatypes)

    1.5. [Java variable types](#java_variabletypes)

    1.6. [Java modifier types](#java_modifiertypes)

    1.7. [Java loop](#java_loop)

    1.8. [Java date](#java_date)

    1.9. [Java array](#java_array)

    1.20. [Java regular expressions](#java_expressions)

2. [Java hướng đối tượng](#java_oop)

   2.1. [Kế thừa](#java_inheritance)



------------------


![](./img/java-mini-logo.png)

# Java cơ bản <a name="java_basic"></a>

## Tổng quan <a name="java_overview"></a>

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

## Cú pháp cơ bản <a name="java_basicsyntax"></a>

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

## Java Object and Class <a name="java_objnclass"></a>

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

### Truy cập các biến và phương thức sơ thẩm

Các biến và các phương thức được kết nối thông qua các đối tượng được tạo. Ví dụ như sau:

```java
// Đầu tiên, tạo một đối tượng
ObjectReference = new Constructor();

// Bây giờ, gọi 1 biến như sau:
ObjectReference.variableName;

// Và gọi một phương thức như sau
ObjectReference.MethodName();
```

Ví dụ:

```java
public class Puppy{
   int age;

   public Puppy(String name){
      System.out.println("Name chosen is:" + name); 
   }

   public void setAge(int age){
      this.age = age;
   }

   public int getAge(){
      System.out.println("Puppy age is:"+age);
      return age;
   }

   public static void main(String []args) {
      /* Tạo đối tượng */
      Puppy myPuppy = new Puppy( "tommy" );

      /* Gọi phương thức set age của class */
      myPuppy.setAge( 2 );

      /* gọi phương thức khác của class để get age */
      myPuppy.getAge( );

      /* Truy cập biến thể hiện (instance variable) của class */
      System.out.println("Variable Value :" + myPuppy.age );
   }
}
```

### Quy tắc khai báo tệp nguồn

Các quy tắc này rất cần thiết khi khai báo *class*, *import* các câu lệnh và báo cáo *package* trong source file.

- Chỉ có thể có duy nhất 1 public class mỗi source file

- Một source file có thể có nhiều non-public class

- Tên của class public cũng là tên của source file. Ví dụ, tên class là Employee{} thì tên source file là Employee.java.

- Nếu class được định nghĩa bên trong một package thì câu lệnh package sẽ là câu lệnh đầu tiên trong tệp nguồn.

- Nếu báo cáo nhập khẩu có mặt, thì chúng phải được viết giữa câu lệnh gói và khai báo lớp. Nếu không có câu lệnh gói, thì câu lệnh nhập phải là dòng đầu tiên trong tệp nguồn.

- Các câu lệnh nhập và gói sẽ ngụ ý tất cả các lớp có trong tệp nguồn. Không thể khai báo các câu lệnh nhập và / hoặc gói khác nhau cho các lớp khác nhau trong tệp nguồn.

### Java package

Nói đơn giản, nó là một cách để phân loại các lớp và các interfaces. 

### Import các câu lệnh

Trong Java nếu một tên đủ điều kiện, bao gồm gói và tên lớp được đưa ra, thì trình biên dịch có thể dễ dàng định vị mã nguồn hoặc các lớp. Import câu lệnh là một cách đưa ra vị trí thích hợp cho trình biên dịch tìm lớp cụ thể đó.

```java
import java.io.*;
```

### Một nghiên cứu trường hợp đơn giản

```java
import java.io.*;
public class Employee {

   String name;
   int age;
   String designation;
   double salary;

   // This is the constructor of the class Employee
   public Employee(String name) {
      this.name = name;
   }

   // Assign the age of the Employee  to the variable age.
   public void empAge(int empAge) {
      age = empAge;
   }

   /* Assign the designation to the variable designation.*/
   public void empDesignation(String empDesig) {
      designation = empDesig;
   }

   /* Assign the salary to the variable	salary.*/
   public void empSalary(double empSalary) {
      salary = empSalary;
   }

   /* Print the Employee details */
   public void printEmployee() {
      System.out.println("Name:"+ name );
      System.out.println("Age:" + age );
      System.out.println("Designation:" + designation );
      System.out.println("Salary:" + salary);
   }
}
```

```java
import java.io.*;
public class EmployeeTest {

   public static void main(String args[]) {
      /* Create two objects using constructor */
      Employee empOne = new Employee("James Smith");
      Employee empTwo = new Employee("Mary Anne");

      // Invoking methods for each object created
      empOne.empAge(26);
      empOne.empDesignation("Senior Software Engineer");
      empOne.empSalary(1000);
      empOne.printEmployee();

      empTwo.empAge(21);
      empTwo.empDesignation("Software Engineer");
      empTwo.empSalary(500);
      empTwo.printEmployee();
   }
}
```
## Cách kiểu dữ liệu cơ bản <a name="java_basicdatatypes"></a>

Trong Java có 2 kiểu dữ liệu là kiểu dữ liệu thông thường và các kiểu dữ liệu tham chiếu/đối tượng.

### Các kiểu dữ liệu thông thường

- **byte** số nguyên 8-bit
- **short** số nguyên 16-bit 
- **int** số nguyên 32-bit  
- **long** số nguyên 64-bit
- **float** số thực chấm động 32-bit
- **double** số thực chấm động 64-bit
- **boolean**
- **char** kí tự 16-bit UNICODE

### Kiểu dữ liệu tham chiếu/đối tượng

### Java literals

Một literal là một source code đại diện cho giá trị cố định. Chúng được biểu diễn trực tiếp trong mã mà không có bất kì tính toán nào.

Literal có thể gán cho bất kì loại biến nào. `byte a = 68; char a = 'A'`.

byte, int, long và short có thể được biểu thị bằng các hệ số thập phân (cơ số 10), thập lục phân (cơ số 16) hoặc bát phân (cơ số 8).

Tiền tố 0 được sử dụng để chỉ số bát phân và tiền tố 0x biểu thị hệ thập lục phân khi sử dụng các hệ thống số này cho các literal,

```java
int decimal = 100;
int octal = 0144;
int hexa =  0x64;
```

Ngôn ngữ Java cũng hỗ trợ một vài chuỗi thoát đặc biệt cho String và char.

|Notation|Character represented
|-|-|
|\n|Newline (0x0a)|
|\r|Carriage return (0x0d)|
|\f|Formfeed (0x0c)|
|\b|Backspace (0x08)|
|\s|Space (0x20)|
|\t|tab|
|\\"|"|
|\\'|'|
|\\\\ |\|
|\ddd|Octal character (ddd)|
|\uxxxx|Hexadecimal UNICODE character (xxxx)|

### Java variable types

`datatype variable [ = value][, variable [ = value] ...] ;`

#### Local variables

#### Instance variables

- Khi một không gian được phân bổ cho một đối tượng trong heap, một vị trí cho mỗi giá trị biến đối tượng được tạo.

- Biến sơ thẩm được tạo khi một đối tượng được tạo với việc sử dụng từ khóa 'mới' và bị hủy khi đối tượng bị hủy.

- Các biến sơ thẩm giữ các giá trị phải được tham chiếu bởi nhiều hơn một phương thức, hàm tạo hoặc khối hoặc các phần thiết yếu của trạng thái của một đối tượng phải có trong toàn bộ lớp

#### Class/Static variables

- Sẽ chỉ có một bản sao của mỗi biến lớp cho mỗi lớp, bất kể có bao nhiêu đối tượng được tạo từ nó.

- Các biến tĩnh hiếm khi được sử dụng ngoài việc được khai báo là hằng số. Các hằng số là các biến được khai báo là public / private, final và static. Các biến không đổi không bao giờ thay đổi từ giá trị ban đầu của chúng.

- Các biến tĩnh được lưu trữ trong bộ nhớ tĩnh. Rất hiếm khi sử dụng các biến tĩnh khác với khai báo cuối cùng và được sử dụng như là hằng số công khai hoặc riêng tư.

- Biến tĩnh được tạo khi chương trình khởi động và hủy khi chương trình dừng.

- Khả năng hiển thị tương tự như các biến thể hiện (instance variable). Tuy nhiên, hầu hết các biến tĩnh được khai báo công khai vì chúng phải có sẵn cho người dùng của lớp.

- Khi khai báo các biến lớp là public static final, thì các tên biến (hằng) đều ở dạng chữ hoa. Nếu các biến tĩnh không public và final, cú pháp đặt tên giống như các biến thể hiện và biến cục bộ.

### Java modifier types <a name="java_modifiertypes"></a>

Có 2 loại access modify và non-access

Ví dụ,
```java
public class className {
   // ...
}

private boolean myFlag;
static final double weeks = 9.5;
protected static final int BOXWIDTH = 42;

public static void main(String[] arguments) {
   // body of method
}
```

#### Access Control Modifiers

Java cung cấp một số access modifier để đặt mức truy cập cho các class, variable, method và constructor. Có 4 mức truy cập:

- Hiển thị với package, mặc định.
- Chỉ hiển thị trong class (private).
- Hiển thị (public).
- Hiển thị với gói và tất cả các class con (protected).

#### Non-Access Modifier.

Java cung cấp một số non-access modifier để đạt được nhiều chức năng khác.

- static modifier để tạo các phương thức và biến lớp.
- final modifier để hoàn thiện việc triển khai các lớp, phương thức và biến.
- abstract modifier để tạo các lớp và phương thức trừu tượng.
- synchronized (đồng bộ) và volatile (bay hơi), được sử dụng cho các luồng.

### Java loop

Cũng ik mấy ngôn ngữ bình thường nhưng có thêm vụ này:

```java
int[] numbers = {1,2,3,4,5,6};

for(int i : numbers){
   System.out.println("so:" + i);
}
```

### Java date

Java cung cấp lớp Date có sẵn trong gói java.util, lớp này gói gọn ngày và giờ hiện tại.

class Date hỗ trợ 2 constructor 

- Date(): constructor này khởi tạo đối tượng với ngày và giờ hiện tại.
- Date(long millisec): constructor này chấp nhận một đối số bằng với số mili giây đã trôi qua kể từ nửa đêm, ngày 1 tháng 1 năm 1970.

Ví dụ lấy ngày giờ hiện tại:

```java
import java.util.Date;
public class DateDemo {

   public static void main(String args[]) {
      // Instantiate a Date object
      Date date = new Date();

      // display time and date using toString()
      System.out.println(date.toString());
   }
}
```

### Java array

#### Khai báo biến mảng

```java
dataType[] arrayRefVar;
```

#### Tạo mảng

```java
arrayRefVar = new dataType[arraySize];
```

#### Array class

java.util.Arrays;

# Java hướng đối tượng <a name="java_oop"></a>

## Kế thừa <a name="java_inheritance"></a>

Kế thừa có thể được định nghĩa là quá trình mà một lớp có được các thuộc tính (các phương thức và các trường) của lớp khác. Việc sử dụng kế thừa thông tin được quản lý theo một thứ tự phân cấp.

Lớp kế thừa các thuộc tính của lớp khác được gọi là lớp con (subclass) (lớp dẫn xuất (devired class), lớp con (child class)).

### Từ khóa extends 

`extends` là từ khóa được sử dụng để kế thừa thuộc tính của 1 class. Cú pháp như sau:

```java
class Animal{
   ....
   ....  
}

class Dog extends Animal{
   ....
   ....
}
```

### Ví dụ

```java
class Calculation {
   int z;
	
   public void addition(int x, int y) {
      z = x + y;
      System.out.println("The sum of the given numbers:"+z);
   }
	
   public void Subtraction(int x, int y) {
      z = x - y;
      System.out.println("The difference between the given numbers:"+z);
   }
}

public class My_Calculation extends Calculation {
   public void multiplication(int x, int y) {
      z = x * y;
      System.out.println("The product of the given numbers:"+z);
   }
	
   public static void main(String args[]) {
      int a = 20, b = 10;
      My_Calculation demo = new My_Calculation();
      demo.addition(a, b);
      demo.Subtraction(a, b);
      demo.multiplication(a, b);
   }
}
```

### Từ khóa super

Từ khóa `super` cũng tương tự như từ khóa `this`. Các tình huống mà từ khóa `super` được sử dụng:

- Dùng để phân biệt các thành viên của `super class` với các thành viên của `subclass` nếu chúng có cùng tên

- Dùng để gọi constructor của super class từ subclass.

#### Phân biệt các thành viên

```java
super.variable;
super.method();
```

#### Gọi constructor của superclass

Nếu 1 lớp đang kế thừa một lớp khác, subclass sẽ tự động lấy constructor của superclass. Dùng từ khóa super để gọi parameterized constructor của superclass.

```java
super(values);
```

#### Ví dụ

```java
class Superclass {
   int age;

   Superclass(int age) {
      this.age = age; 		 
   }

   public void getAge() {
      System.out.println("The value of the variable named age in super class is: " +age);
   }
}

public class Subclass extends Superclass {
   Subclass(int age) {
      super(age);
   }

   public static void main(String args[]) {
      Subclass s = new Subclass(24);
      s.getAge();
   }
}
```

### IS-A Relationship

`This object is a type of that object`, ví dụ như vầy:

```java
public class Animal {
}

public class Mammal extends Animal {
}

public class Reptile extends Animal {
}

public class Dog extends Mammal {
}
```

Như vậy, ta nói:

- Mammal IS-A Animal
- Reptile IS-A Animal
- Dog IS-A Mammal
- Hence: Dog IS-A Animal as well

### Từ khóa intanceof

Dùng từ khóa `intanceof` để kiểm tra class này có thuộc class kia hay không.

```java
interface Animal{}
class Mammal implements Animal{}

public class Dog extends Mammal {

   public static void main(String args[]) {
      Mammal m = new Mammal();
      Dog d = new Dog();

      System.out.println(m instanceof Animal);
      System.out.println(d instanceof Mammal);
      System.out.println(d instanceof Animal);
   }
}
```

### HAS-A relationship

Các mối quan hệ này chủ yếu dựa trên cách sử dụng. 

```java
public class Vehicle{}
public class Speed{}

public class Van extends Vehicle {
   private Speed sp;
} 
```

### Kiểu của kế thừa

![](./img/types_of_inheritance.jpg)

Tuy nhiên, java không hổ trợ đa kế thừa (multiple inheritance). Điều này có nghĩa là một class không thể extends nhiều hơn 1 class.

Tuy nhiên, một class có thể triển khai được nhiều giao diện, điều này giúp java thoát khỏi tình trạng đa kế thừa bất khả thi.


----------------------------

----------------------------

# Khái niệm tight-coupling (liên kết ràng buộc) và cách loosely coupled
