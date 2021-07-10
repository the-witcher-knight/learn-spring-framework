# Cơ bản về Reactor Project

Trong Reactive Programming, khả năng của máy khách báo hiệu mức độ công việc mà nó có thể quản lý được gọi là *blackpressure* (áp suất ngược).

[Reactor](https://projectreactor.io/) là 1 project của Spring team.

[Reactive Streams initiative](http://www.reactive-streams.org/) định nghĩa 4 type:

`Publisher<T>` là một nhà sản xuất các giá trị mà cuối cùng cũng có thể đến. 1 `Publisher<T>` cung cấp những giá trị kiểu `T` để `Subscriber<T>`.

Ví dụ: Reactive Streams `Publisher<T>`

```Java
public interface Publisher<T> {
  void subscribe(Subscriber<? super T> s);
}
```

`Subscriber` đăng ký một `Publisher<T>`, nhận thông báo về bất kì giá trị mới nào của loại `T` thông qua phương thức `onNext(T)`. Nếu có bất kì lỗi nào thì phương thức `onError(Throwable)` sẽ được gọi. Khi quả trình xử lý hoàn tất bình thường thì phương thức `onComplete` sẽ được gọi.

ví dụ: Reactive Streams `Subscriber<T>`

```Java
package org.reactivestreams;

public interface Subscriber<T> {
  public void onSubscriber(Subscrition s);
  public void onNext(T t);
  public void onError(Throwable t);
  public void onComplete();
}
```

Khi 1 `Subscriber` kết nối với `Publisher` lần đầu tiên, nó được cấp một `Subscription` trong phương thức `onSubscriber`. `Subscription` được cho là phần quan trọng nhất của toàn bộ thông số kỹ thuật: nó cho phép `backpressure`. `Subscriber` sử dụng phương thức `Subscription#request` để yêu cầu thêm data hoặc `Subscription#cancel` để tạm dừng xử lý.

ví dụ: Reactive Streams `Subscription<T>`

```java
package org.reactivestreams;

public interface Subscription {
  public void request(long n);

  public void cancel();
}
```

Reactive Streams cung cấp type A `Precessor<A, B>` là một interface đơn giản kế thừa cả `Subscriber<A>` và `Publisher<B>`.

ví dụ: Reactive Streams `Processor<T>`

```Java
package org.reactivestreams;

public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {

}
```

Tuy nhiên, các Reactive Streams là không đủ; ta cần triển khai tứ tự cao hơn để hỡ trợ các hoạt đợng như lọc và chuyển đổi. Reactor project được xâu dựng dựa trên đặc điểm kỹ thuật của `Reactive Streams`. Nó cung cấp 2 chuyên môn (specializations) của `Publisher<T>`.

- `Flux<T>` là 1 `Publisher` cung cấp không hoặc nhiều giá trị, nó không bị ràng buộc.
- `Mono<T>` là 1 `Publisher` cung cấp không hoặc 1 giá trị.

Cả 2 thằng trên đều là publisher và mày có thể sử dụng 2 thằng trên theo các đó, nhưng nó còn đi xa hơn nhiều so với đặc tả Reactive Streams. Cả 2 đều cung cấp các operators, các để xử lý stream của những giá trị. 

> Các kiểu Reactor soạn thảo một cách độc đáo - đầu ra của một thứ có thể là đầu vào của 1 thứ khác và nều 1 type cần hoạt đợng với các luồng dữ liệu khác, chúng sẽ dựa vào các cá thể của `Publisher<T>`.

Cả 2 `Mono<T>` và `Flux<T>` triển khai `Publisher<T>`; nhưng tốt nhất nên trả về `Mono<T>` hoặc `Flux<T>` để phân biệt các loại dữ liệu mà nó đang được cung cấp.

> Trang list thì dùng Flux, trang detail thì dùng Mono