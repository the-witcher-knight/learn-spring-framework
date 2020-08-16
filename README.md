
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

   2.2. [Overriding](#java_overriding)

   2.3. [Đa hình](#java_polymorphism)

   2.4. [Trừu tượng](#java_abstraction)

   2.5. [Tính bao đóng](#java_encapsulation)

   2.6. [Giao diện](#java_interfaces)

   2.7. [Package](#java_package)

3. [Spring boot](#java_springboot)

   3.1. [Các khái niệm cần nắm](#spring_other)

   3.2. [Cách cài đặt](#spring_install)

   3.2. [@Component và @Autowired](#springboot_1)

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

Tuy nhiên, một class có thể triển khai được nhiều interfaces, điều này giúp java thoát khỏi tình trạng đa kế thừa bất khả thi.

## Overriding <a name="java_overriding"></a>

Một class kế thừa những phương thức từ superclass thì có khả năng overriding class đó.

Lợi ích của việc ghi đè là: khả năng xác định một hành vi cụ thể cho kiểu lớp con, có nghĩa là một lớp con có thể triển khai một phương thức của lớp cha dựa trên yêu cầu của nó.

### Ví dụ

```java
class Animal {
   public void move() {
      System.out.println("Animals can move");
   }
}

class Dog extends Animal {
   public void move() {
      System.out.println("Dogs can walk and run");
   }
}

public class TestDog {

   public static void main(String args[]) {
      Animal a = new Animal();   // Animal reference and object
      Animal b = new Dog();   // Animal reference but Dog object

      a.move();   // runs the method in Animal class
      b.move();   // runs the method in Dog class
   }
}
```

### Quy tắc method overriding 

- Danh sách đối số phải hoàn toàn giống với danh sách của phương thức được overriding.
- Kiểu trả về phải giống hoặc là một kiểu con của kiểu trả về được khai báo trong phương thức ghi đè ban đầu trong superclass.
- Cấp truy cập không thể hạn chế hơn cấp truy cập của phương thức bị ghi đè. Ví dụ: nếu phương thức trong superclass là public thì phương thức overriding trong subclass không thể là private hoắc protected.
- Các instance method chỉ có thể được ghi đè (override) nếu chúng được kế thừa bởi subclass.
- Không thể ghi đè phương thức final.
- Một phương thức static không thể bị ghi đè (override) nhưng có thể định nghĩa lại.
- Nếu một phương thức không được kế thừa thì nó không thể ghi đè.
- Một subclass trong cùng một package với superclass có thể ghi đè mọi phương thức của superclass trừ các phương thức private và final.
- Một lớp con trong một gói khác chỉ có thể ghi đè các phương thức không phải là phương thức final được khai báo là public hoặc protected.
- Một phương thức ghi đè có thể `throw any uncheck exception`, bất kể phương thức được ghi đè có throw exception hay không. Tuy nhiên, phương thức ghi đè không được `throw checked exceptions` mới hoặc rộng hơn các exception được khai báo bởi phương thức ghi đè. Phương thức ghi đè có thể đưa ra các exception hẹp hơn hoặc ít hơn phương thức ghi đè.
- Constructors không thể bị ghi đè.

### Sử dụng từ khóa super

Khi gọi một phiên bản superclass của một phương thức được ghi đè, từ khóa super được sử dụng.

```java
class Animal {
   public void move() {
      System.out.println("Animals can move");
   }
}

class Dog extends Animal {
   public void move() {
      super.move();   // invokes the super class method
      System.out.println("Dogs can walk and run");
   }
}

public class TestDog {

   public static void main(String args[]) {
      Animal b = new Dog();   // Animal reference but Dog object
      b.move();   // runs the method in Dog class
   }
}
```

## Đa hình <a name="java_polymorphism"></a>

Tính đa hình là khả năng của một đối tượng có nhiều dạng. Việc sử dụng đa hình phổ biến nhất trong OOP xảy ra khi một tham chiếu lớp cha được sử dụng để tham chiếu đến một đối tượng lớp con.

Bất kỳ đối tượng Java nào có thể vượt qua nhiều hơn một bài kiểm tra IS-A đều được coi là đa hình. Trong Java, tất cả các đối tượng Java đều là đa hình vì bất kỳ đối tượng nào cũng sẽ vượt qua bài kiểm tra IS-A cho kiểu riêng của chúng và cho lớp Đối tượng.

Biến tham chiếu có thể được gán lại (reassigned) cho các đối tượng khác miễn là nó không được khai báo final. Kiểu của biến tham chiếu sẽ xác định các phương thức mà nó có thể gọi trên đối tượng.

Một biến tham chiếu (reference variable) có thể tham chiếu đến bất kỳ đối tượng nào thuộc kiểu được khai báo của nó hoặc bất kỳ kiểu con nào (subtype) của kiểu được khai báo. Một biến tham chiếu có thể được khai báo dưới dạng class hoặc interface type.

### Ví dụ

```java
public interface Vegetarian{}
public class Animal{}
public class Deer extends Animal implements Vegetarian{}
```

class `Deer` được coi là đa hình vì nó có đa kế thừa. 
- A Deer IS-A Animal
- A Deer IS-A Vegetarian
- A Deer IS-A Deer
- A Deer IS-A Object

Vì vậy, các khai báo sau đây là hợp pháp:

```java
Deer d = new Deer();
Animal a = d;
Vegetarian v = d;
Object o = d;
```

Tất cả các biến tham chiếu d, a, v, o tham chiếu đến cùng một đối tượng Deer trong heap.

### Vitual method

```java
/* File name : Employee.java */
public class Employee {
   private String name;
   private String address;
   private int number;

   public Employee(String name, String address, int number) {
      System.out.println("Constructing an Employee");
      this.name = name;
      this.address = address;
      this.number = number;
   }

   public void mailCheck() {
      System.out.println("Mailing a check to " + this.name + " " + this.address);
   }

   public String toString() {
      return name + " " + address + " " + number;
   }

   public String getName() {
      return name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String newAddress) {
      address = newAddress;
   }

   public int getNumber() {
      return number;
   }
}
```

Sau đó, kế thừa class nhân viên

```java
/* File name : Salary.java */
public class Salary extends Employee {
   private double salary; // Annual salary
   
   public Salary(String name, String address, int number, double salary) {
      super(name, address, number);
      setSalary(salary);
   }
   
   public void mailCheck() {
      System.out.println("Within mailCheck of Salary class ");
      System.out.println("Mailing check to " + getName()
      + " with salary " + salary);
   }
   
   public double getSalary() {
      return salary;
   }
   
   public void setSalary(double newSalary) {
      if(newSalary >= 0.0) {
         salary = newSalary;
      }
   }
   
   public double computePay() {
      System.out.println("Computing salary pay for " + getName());
      return salary/52;
   }
}
```

```java
/* File name : VirtualDemo.java */
public class VirtualDemo {

   public static void main(String [] args) {
      Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
      Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
      System.out.println("Call mailCheck using Salary reference --");   
      s.mailCheck();
      System.out.println("\n Call mailCheck using Employee reference--");
      e.mailCheck();
   }
}
```

Kết quả của chương trình:

```
Constructing an Employee
Constructing an Employee

Call mailCheck using Salary reference --
Within mailCheck of Salary class
Mailing check to Mohd Mohtashim with salary 3600.0

Call mailCheck using Employee reference--
Within mailCheck of Salary class
Mailing check to John Adams with salary 2400.0
```

Ở đây, chúng tôi khởi tạo hai đối tượng `Salary`. Một sử dụng tham chiếu `Salary` s, và một sử dụng tham chiếu `Employee` e.

Trong khi gọi s.mailCheck(), trình biên dịch sẽ thấy mailCheck() trong lớp Salary tại thời điểm biên dịch và JVM gọi mailCheck() trong lớp Salary tại thời điểm chạy.

mailCheck() trên e khá khác vì e là tham chiếu của Employee. Khi trình biên dịch thấy e.mailCheck(), trình biên dịch sẽ thấy phương thức mailCheck() trong lớp Employee.

Ở đây, tại thời điểm biên dịch, trình biên dịch đã sử dụng mailCheck() trong Employee để xác thực câu lệnh này. Tuy nhiên, tại thời điểm chạy, JVM gọi mailCheck() trong lớp Salary.

Hành vi này được gọi là lệnh gọi phương thức ảo (Vitual method invocation) và các phương thức này được gọi là phương thức ảo (Vitual method). Một phương thức ghi đè được gọi trong thời gian chạy, bất kể kiểu dữ liệu nào mà tham chiếu được sử dụng trong mã nguồn tại thời điểm biên dịch.

## Trừu tượng <a name="java_abstraction"></a>

Theo từ điển, trừu tượng là chất lượng của việc xử lý các ý tưởng hơn là các sự kiện.

Trong lập trình hướng đối tượng, trừu tượng hóa là một quá trình ẩn các chi tiết triển khai khỏi người dùng, chỉ chức năng sẽ được cung cấp cho người dùng. Nói cách khác, người dùng sẽ có thông tin về những gì đối tượng làm thay vì cách nó thực hiện.

Trong Java trừu tượng hóa đạt được bằng cách dùng abstract classes và interfaces.

### Abstrac class

Một class có chứa từ khóa abstract trong khai báo của nó được gọi là class trừu tượng.

- Các lớp trừu tượng có thể chứa hoặc không chứa các phương thức trừu tượng (abstract method) - các phương thức không có phần thân. `public void get();`.

- Một class có ít nhất 1 phương thức trừu tượng thì class đó `phải` được khai báo abstract.

- Nếu một class được khai báo abstract thì class đó không được tạo ra.

- Để sử dụng một lớp trừu tượng, bạn phải kế thừa nó từ một lớp khác, cung cấp các triển khai cho các phương thức trừu tượng trong đó.

- Nếu bạn kế thừa một lớp trừu tượng, bạn phải cung cấp các triển khai cho tất cả các phương thức trừu tượng trong đó.

### Ví dụ

```java
/* File name : Employee.java */
public abstract class Employee {
   private String name;
   private String address;
   private int number;

   public Employee(String name, String address, int number) {
      System.out.println("Constructing an Employee");
      this.name = name;
      this.address = address;
      this.number = number;
   }
   
   public double computePay() {
     System.out.println("Inside Employee computePay");
     return 0.0;
   }
   
   public void mailCheck() {
      System.out.println("Mailing a check to " + this.name + " " + this.address);
   }

   public String toString() {
      return name + " " + address + " " + number;
   }

   public String getName() {
      return name;
   }
 
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String newAddress) {
      address = newAddress;
   }
 
   public int getNumber() {
      return number;
   }
}
```

Bạn có thể thấy rằng ngoại trừ các phương thức trừu tượng, lớp Employee giống như lớp bình thường trong Java. Lớp bây giờ là trừu tượng, nhưng nó vẫn có ba trường, bảy phương thức và một constructor.

### Kế thừa abstract class

```java
/* File name : Salary.java */
public class Salary extends Employee {
   private double salary;   // Annual salary
   
   public Salary(String name, String address, int number, double salary) {
      super(name, address, number);
      setSalary(salary);
   }
   
   public void mailCheck() {
      System.out.println("Within mailCheck of Salary class ");
      System.out.println("Mailing check to " + getName() + " with salary " + salary);
   }
 
   public double getSalary() {
      return salary;
   }
   
   public void setSalary(double newSalary) {
      if(newSalary >= 0.0) {
         salary = newSalary;
      }
   }
   
   public double computePay() {
      System.out.println("Computing salary pay for " + getName());
      return salary/52;
   }
}
```

Ở đây, bạn không thể khởi tạo lớp Nhân viên, nhưng bạn có thể khởi tạo Lớp Lương và sử dụng trường hợp này, bạn có thể truy cập tất cả ba trường và bảy phương thức của lớp Nhân viên như được hiển thị bên dưới.

```java
/* File name : AbstractDemo.java */
public class AbstractDemo {

   public static void main(String [] args) {
      Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
      Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
      System.out.println("Call mailCheck using Salary reference --");
      s.mailCheck();
      System.out.println("\n Call mailCheck using Employee reference--");
      e.mailCheck();
   }
}
```

### Phương thức abstract

Nếu bạn muốn một class chứa một phương thức cụ thể nhưng bạn muốn việc triển khai thực sự của phương thức đó được xác định bởi các subclass, bạn có thể khai báo phương thức trong superclass dưới dạng trừu tượng.

- Từ khóa abstract được sử dụng trong khởi tạo phương thức abstract.

- Phương thức abstract là phương thức rỗng phần thân.

- Phương thức abstact có dấu `;` thay vì cặp dấu `{}`.

```java
public abstract class Employee {
   private String name;
   private String address;
   private int number;
   
   public abstract double computePay();
   // Remainder of class definition
}
```

Khai báo một phương thức là trừu tượng có 2 hệ quả.

- Class chứa nó phải là class trừu tượng.

- Bất kỳ lớp nào kế thừa lớp hiện tại phải ghi đè phương thức trừu tượng hoặc khai báo chính nó là trừu tượng.

> Cuối cùng, một lớp con phải triển khai phương thức trừu tượng; nếu không, bạn sẽ có một hệ thống phân cấp các lớp trừu tượng không thể được khởi tạo.

Giả sử lớp Salary kế thừa lớp Employee, thì nó sẽ triển khai phương thức computePay(), như sau:

```java
/* File name : Salary.java */
public class Salary extends Employee {
   private double salary;   // Annual salary
  
   public double computePay() {
      System.out.println("Computing salary pay for " + getName());
      return salary/52;
   }
   // Remainder of class definition
}
```

## Giao diện <a name='java_interfaces'></a>

Interface là một kiểu tham chiếu trong Java. Nó tương tự như class. Nó là một tập hợp các phương thức trừu tượng. Một lớp thực hiện một interface, do đó kế thừa các phương thức trừu tượng của interface.

Cùng với các phương thức trừu tượng, một interface cũng có thể chứa các hằng số, phương thức mặc định, phương thức tĩnh và các kiểu lồng nhau. Các thân phương thức chỉ tồn tại cho các phương thức mặc định và phương thức tĩnh.

Viết một interface tương tự như viết một class. Nhưng một lớp mô tả các thuộc tính và hành vi của một đối tượng. Và một interface chứa các hành vi mà một lớp thực hiện.

Trừ khi class triển khai interface là trừu tượng, tất cả các phương thưc của interface cần được định nghĩa trong class.

Interface tương tự class ở những đặc điểm sau:

- Một interface có thể chứa nhiều phương thức.

- Giao diện được viết trong tệp có phần mở rộng .java, với tên của interface khớp với tên của tệp.

- Mã byte của interface xuất hiện trong tệp .class.

- Các interface xuất hiện trong các package và tệp bytecode tương ứng của chúng phải nằm trong cấu trúc thư mục khớp với tên gói.

Tuy nhiên, interface `khác` với class ở những điểm sau đây:

- Không thể implement một interface.

- Interface không chứa constructor.

- Tất cả các phương thức của interface phải là trừu tượng

- Một interface không thể chứa các trường cá thể. Các trường duy nhất có thể xuất hiện trong giao diện phải được khai báo cả static và final.

- Một interface không được mở rộng bởi một class; nó được thực hiện bởi một class.

- Một interface có thể extends được nhiều interface

### Khởi tạo interface

```java
/* File name : NameOfInterface.java */
import java.lang.*;
// Any number of import statements

public interface NameOfInterface {
   // Any number of final, static fields
   // Any number of abstract method declarations\
}
```

Các interfaces cần có thuộc tính sau:

- Một giao diện là hoàn toàn trừu tượng. Bạn không cần phải sử dụng từ khóa trừu tượng trong khi khai báo một giao diện.

- Mỗi phương thức trong một giao diện cũng hoàn toàn trừu tượng, vì vậy từ khóa trừu tượng không cần thiết

- Các phương thức trong một giao diện là hoàn toàn công khai.

### Implementing interface

Khi một lớp triển khai một interface, bạn có thể coi lớp đó giống như việc ký một hợp đồng, đồng ý thực hiện các hành vi cụ thể của interface. Nếu một lớp không thực hiện tất cả các hành vi của giao diện, thì lớp đó phải tự khai báo là abstract.

Một lớp sử dụng từ khóa `implements` để triển khai một giao diện. Từ khóa triển khai xuất hiện trong khai báo lớp sau phần mở rộng của khai báo.

```java
/* File name : MammalInt.java */
public class MammalInt implements Animal {

   public void eat() {
      System.out.println("Mammal eats");
   }

   public void travel() {
      System.out.println("Mammal travels");
   } 

   public int noOfLegs() {
      return 0;
   }

   public static void main(String args[]) {
      MammalInt m = new MammalInt();
      m.eat();
      m.travel();
   }
}
```

Khi ghi đè các phương thức trong interface cần tuân thủ các quy tắc sau:

- Các checked exception không nên được khai báo trên các phương thức triển khai khác với các ngoại lệ được khai báo bởi phương thức giao diện hoặc các lớp con của những ngoại lệ được khai báo bởi phương thức giao diện.

- Chữ ký của phương thức giao diện và kiểu trả về hoặc kiểu con giống nhau nên được duy trì khi ghi đè các phương thức.

- Bản thân một lớp thực thi có thể trừu tượng và nếu vậy, các phương thức giao diện không cần được thực hiện.

Khi triển khai giao diện cần tuân thủ những quy tắc sau:

- Một class có thể triển khai nhiều giao diện cùng lúc.

- Một class chỉ có thể extends 1 class nhưng có thể triển khai nhiều interface.

- Một giao diện có thể mở rộng một giao diện khác, theo cách tương tự như một lớp có thể mở rộng một lớp khác.

### Extending interfaces

Một interface có thể mở rộng một interface khác giống như cách mà một class có thể mở rộng một class khác. Từ khóa `extends` được sử dụng để mở rộng interface và interface con kế thừa các phương thức của interface mẹ.

### Ví dụ

```java
// Filename: Sports.java
public interface Sports {
   public void setHomeTeam(String name);
   public void setVisitingTeam(String name);
}

// Filename: Football.java
public interface Football extends Sports {
   public void homeTeamScored(int points);
   public void visitingTeamScored(int points);
   public void endOfQuarter(int quarter);
}

// Filename: Hockey.java
public interface Hockey extends Sports {
   public void homeGoalScored();
   public void visitingGoalScored();
   public void endOfPeriod(int period);
   public void overtimePeriod(int ot);
}
```

### Extending multiple interfaces

Một interface có thể extends nhiều interface khác

```java
public interface Hockey extends Sports, Event
```

### Tagging interfaces

Việc sử dụng giao diện mở rộng (extending interfaces) phổ biến nhất xảy ra khi giao diện mẹ không chứa bất kỳ phương thức nào. Ví dụ: giao diện MouseListener trong gói java.awt.event mở rộng java.util.EventListener, được định nghĩa là:

#### Ví dụ

```java
package java.util;
public interface EventListener
{}
```

Một giao diện không có phương thức nào được gọi là `tagging interface`. Có 2 mục đích thiết kế cơ bản của `tagging interface`:

- `Creates a common parent`: Như với giao diện EventListener, được mở rộng bởi hàng chục giao diện khác trong Java API, bạn có thể sử dụng giao diện gắn thẻ để tạo một giao diện mẹ chung giữa một nhóm giao diện. Ví dụ: khi một giao diện mở rộng EventListener, JVM biết rằng giao diện cụ thể này sẽ được sử dụng trong một kịch bản ủy quyền sự kiện.

- `Adds a data type to a class`: Tình huống này là nguồn gốc của thuật ngữ, gắn thẻ. Một lớp thực hiện giao diện gắn thẻ không cần xác định bất kỳ phương thức nào (vì giao diện không có bất kỳ phương thức nào), nhưng lớp này trở thành một kiểu giao diện thông qua tính đa hình.

### Java package <a name="java_package"></a>
--------------------------------------------
-----------------------------------------------------------------------------------

![](./img/spring-boot.png)


# Learn Spring Boot Framwork

## Các khái niệm cần nắm <a name="java_other></a>

### Khái niệm tight-coupling (liên kết ràng buộc) và cách loosely coupled (liên kết lỏng lẻo)

`tight-coupling` hay "liên kết ràng buộc" là một khái niệm trong Java ám chỉ việc mối quan hệ giữa các Class quá chặt chẽ. Khi yêu cầu thay đổi logic hay một class bị lỗi sẽ dẫn tới ảnh hưởng tới toàn bộ các Class khác.

`loosely-coupled` là cách ám chỉ việc làm giảm bớt sự phụ thuộc giữa các Class với nhau.

#### Ví dụ

1. Các code level 1

```java
public class BubbleSortAlgorithm{
   public void sort(int[] array) {
      // TODO: Add your logic here
      System.out.println("Đã sắp xếp bằng thuật toán sx nổi bọt");
   }
}

public class VeryComplexService {
   private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

   public VeryComplexService(){
   }

   public void complexBusiness(int array[]){
      bubbleSortAlgorithm.sort(array);
      // TODO: more logic here
   }
}
```

Với cách làm ở trên, `VeryComplexService` đã hoàn thiện được nhiệm vụ, tuy nhiên, khi có yêu cầu thay đổi thuật toán sắp xếp sang QuickSort thì nghe vẻ chúng ta sẽ phải sửa lại hoàn toàn cả 2 Class trên.

Ngoài ra `BubbleSortAlgorithm` sẽ chỉ tồn tại nếu `VeryComplexService` tồn tại, vì `VeryComplexService` tạo đối tượng `BubbleSortAlgorithm` bên trong nó (hay nói cách khác là sự sống chết của `BubbleSortAlgorithm` sẽ do `VeryComplexService` quyết định), theo như cách implement này, nó là liên kết rất chặt với nhau.

2. Cách code level 2

```java
public interface SortAlgorithm {
    /**
     * Sắp xếp mảng đầu vào
     * @param array
     */
    public void sort(int array[]);
}

public class BubbleSortAlgorithm implements SortAlgorithm{

    @Override
    public void sort(int[] array) {
        // TODO: Add your logic here
        System.out.println("Đã sắp xếp bằng thuật toán sx nổi bọt");
    }
}


public class VeryComplexService {
    private SortAlgorithm sortAlgorithm;
    public VeryComplexService(){
        sortAlgorithm = new BubbleSortAlgorithm();
    }

    public void complexBusiness(int array[]){
        sortAlgorithm.sort(array);
        // TODO: more logic here
    }
}
```

Với cách làm này, `VeryComplexService` sẽ chỉ quan hệ với một interface `SortAlgorithm`. Với cách này thì mỗi quan hệ giảm bớt sự liên kết, nhưng nó không thay đổi được việc thuật toán vẫn đang là `BubbleSortAlgorithm`.

3. Cách code level 3

```java
public interface SortAlgorithm {
   /**
   * Sắp xếp mảng đầu vào
   * @param array
   */
   public void sort(int array[]);
}

public class BubbleSortAlgorithm implements SortAlgorithm{

   @Override
   public void sort(int[] array) {
      // TODO: Add your logic here
      System.out.println("Đã sắp xếp bằng thuật toán sx nổi bọt");
   }
}

public class QuicksortAlgorithm implements SortAlgorithm {
   @Override
   public void sort(int[] array) {
      // TODO: Add your logic here
      System.out.println("Đã sắp xếp bằng thuật sx nhanh");
   }
}

public class VeryComplexService {
   private SortAlgorithm sortAlgorithm;
   public VeryComplexService(SortAlgorithm sortAlgorithm){
      this.sortAlgorithm = sortAlgorithm;
   }

   public void complexBusiness(int array[]){
      sortAlgorithm.sort(array);
      // TODO: more logic here
   }
}

public static void main(String[] args) {
   SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
   SortAlgorithm quickSortAlgorithm = new QuicksortAlgorithm();
   VeryComplexService business1 = new VeryComplexService(bubbleSortAlgorithm);
   VeryComplexService business2 = new VeryComplexService(quickSortAlgorithm);
}
```

Cách thứ ba này cũng là cách làm phổ biển nhất. Mối liên hệ giữa 2 Class đã "lỏng lẻo" hơn trước rất nhiều. `VeryComplexService` sẽ không quan tâm tới việc thuật toán sắp xép là gì nữa, mà chỉ cần tập trung vào nghiệp vụ. Còn `SortAlgorithm` sẽ được đưa vào từ bên ngoài tùy theo nhu cầu sử dụng.

### Tiêm phụ thuộc (dependency injection) và IoC (Inversion of Control) 

1. DI

> Các class không nên phụ thuộc vào các kế thừa cấp thấp mà nên phụ thuộc vào class abstraction.

`Dependency Injection` là việc các Object nên phụ thuộc vào các Abstract Class và thể hiện chi tiết của nó sẽ được Inject vào đối tượng lúc runtime.

Các cách để Inject dependency vào một đối tượng có thể kể đến như sau:

- Constructor Injection: Cái này chính là ví dụ của mình, tiêm dependency ngay vào Contructor cho tiện.

- Setter Injection: Ồ, sao không chứ 😗 chúng ta học về Setter từ những bài học vỡ lòng rồi, quá hợp lý. Xài girl.setOutfit(new Naked()) 😈

- Interface Injection: Mỗi Class muốn inject cái gì, thì phải implement một Interface có chứa một hàm inject(xx) (Gần như thay thế cho setter ý bạn). Rồi bạn muốn inject gì đó thì gọi cái hàm inject(xx) ra. Cách này hơi dài và khó cho người mới.

2. IoC

> Inversion of Control is a programming principle. flow of control within the application is not controlled by the application itself, but rather by the underlying framework.

Ta định nghĩa trước toàn bộ các `dependency` có trong Project, mô tả nó và tống nó vào 1 cái kho và giao cho một thằng tên là `framework` quản lý. Bất kỳ các `Class` nào khi khởi tạo, nó cần `dependency` gì, thì cái `framework` này sẽ tự tìm trong kho rồi `inject` vào đối tượng thay chúng ta.

## Cách cài đặt <a name="spring_install"></a>

1. Tạo một Spring boot project 

Vào https://start.spring.io/ tạo 1 project . Ở đây sử dụng `maven` và package là `com.example.blog`

Nếu trong `Java` truyền thống, khi chạy cả một project, chúng ta sẽ phải định nghĩa một hàm `main()` và để nó khởi chạy đầu tiên.

Thì **Spring Boot** cũng vậy, chúng ta sẽ phải chỉ cho **Spring Boot** biết nơi nó khởi chạy lần đầu, để nó cài đặt mọi thứ.

Cách thực hiện là thêm annotation `@SpringBootApplication` trên class chính và gọi `SpringApplication.run(BlogApplication.class, args);` để chạy project.

```java
package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
```

Một trong những nhiệm vụ chính của Spring là tạo ra một cái Container chứa các Dependency cho chúng ta.

`SpringApplication.run(BlogApplication.class, args);` chính là câu lệnh *để tạo ra* **container**. Sau đó nó *tìm toàn bộ* các **dependency** trong project của bạn và đưa vào đó.

Spring đặt tên cho **container** là ***ApplicationContext***

và đặt tên cho các **dependency** là ***Bean***


## Hướng dẫn @Component và @Autowired <a name="springboot_1"></a>

`@Component` và `@Autowire` là 2 annotation (chú thích) cơ bản trong Spring boot.

1. @Component là một Annotation đánh dấu trên các `class` để giúp **Spring** biết đó là một `bean`.

Ví dụ:

Ta có một interface `outfit`

```java
public interface Outfit {
   public void wear();
}
```

implement nó là Class `Bikini`

```java
/*
 Đánh dấu class bằng @Component
 Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 Và sẽ được Spring Boot quản lý
*/
@Component
public class Bikini implements Outfit {
   @Override
   public void wear() {
      System.out.println("Mặc bikini");
   }
}
```

Và chạy chương trình
```java
@SpringBootApplication
public class App {
   public static void main(String[] args) {
      // ApplicationContext chính là container, chứa toàn bộ các Bean
      ApplicationContext context = SpringApplication.run(App.class, args);

      // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
      // dấu @Component.

      // Lấy Bean ra bằng cách
      Outfit outfit = context.getBean(Outfit.class);

      // In ra để xem thử nó là gì
      System.out.println("Instance: " + outfit);
      // xài hàm wear()
      outfit.wear();
   }
}
```

Bạn sẽ thấy `Outfit` lúc này chính là `Bikini`. Class đã được đánh dấu là `@Component`.

**Spring Boot** khi chạy sẽ dò tìm toàn bộ các *Class* cùng cấp hoặc ở trong các *package* thấp hơn so với class `BlogApplication` mà bạn cung cấp cho Spring (Chúng ta có thể cấu hình việc tìm kiếm này, sẽ đề cập sau). 
Trong quá trình dò tìm này, khi gặp một *class* được đánh dấu `@Component` thì nó sẽ tạo ra một *instance* và đưa vào `ApplicationContext` để quản lý.

2. @Autowired

Bây giờ mình tạo ra một Class `Girl` và có một thuộc tính là `Outfit`.

Mình cũng đánh dấu `Girl` là một `@Component`. Tức **Spring Boot** cần tạo ra một *instance* của `Girl` để quản lý.

```java
@Component
public class Girl {

   @Autowired
   Outfit outfit;

   public Girl(Outfit outfit) {
      this.outfit = outfit;
   }
   
   // GET 
   // SET
}
```

Tôi đánh dấu thuộc tính `Outfit` của `Girl` bởi Annotation `@Autowired`. Điều này nói với **Spring Boot** hãy tự *inject (tiêm)* một instance của `Outfit` vào thuộc tính này khi khởi tạo `Girl`.

Và chạy chương trình

```java
@SpringBootApplication
public class App {
   public static void main(String[] args) {
      // ApplicationContext chính là container, chứa toàn bộ các Bean
      ApplicationContext context = SpringApplication.run(App.class, args);

      // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
      // dấu @Component.

      // Lấy Bean ra bằng cách
      Outfit outfit = context.getBean(Outfit.class);

      // In ra để xem thử nó là gì
      System.out.println("Output Instance: " + outfit);
      // xài hàm wear()
      outfit.wear();

      Girl girl = context.getBean(Girl.class);

      System.out.println("Girl Instance: " + girl);

      System.out.println("Girl Outfit: " + girl.outfit);

      girl.outfit.wear();
   }
}
```

**Spring Boot** đã tự tạo ra một `Girl` và trong quá trình tạo ra đó, nó truyền `Outfit` vào làm thuộc tính.

3. Singleton

Điều đặc biệt là các `Bean` được quản lý bên trong `ApplicationContext` đều là ***singleton***. Bạn chắc đã để ý điều này từ các *Output* ở phía trên.

```
Instance: com.example.blog.Bikini@54336c81

Girl Outfit: com.example.blog.Bikini@54336c81
```

`Outfit` ở 2 đối tượng trên là một.

Tất cả những `Bean` được quản lý trong `ApplicationContext` đều chỉ được tạo ra **một lần duy nhất** và khi có `Class` yêu cầu `@Autowired` thì nó sẽ lấy đối tượng có sẵn trong `ApplicationContext` để inject vào.

Trong trường hợp bạn muốn mỗi lần sử dụng là một instance hoàn toàn mới. Thì hãy đánh dấu `@Component` đó bằng `@Scope("prototype")`

```java
@Component
@Scope("prototype")
public class Bikini implements Outfit {
   @Override
   public void wear() {
      System.out.println("Mặc bikini");
   }
}
```