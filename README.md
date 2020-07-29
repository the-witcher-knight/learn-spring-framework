# Learn Spring Boot
------------------
table of contents

1. [Java cơ bản](#java_basic) 
    1.1. [Tổng quan](#java_overview) 
    1.2. [Cú pháp cơ bản](#java_basicsyntax)
------------------


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

----------------------------

----------------------------

# Khái niệm tight-coupling (liên kết ràng buộc) và cách loosely coupled
