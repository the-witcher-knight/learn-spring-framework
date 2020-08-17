table of contents

Java hướng đối tượng

1. [Kế thừa](#java_inheritance)

2. [Overriding](#java_overriding)

3. [Đa hình](#java_polymorphism)

4. [Trừu tượng](#java_abstraction)

5. [Tính bao đóng](#java_encapsulation)

6. [Giao diện](#java_interfaces)

7. [Package](#java_package)

----------------------------------------------

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