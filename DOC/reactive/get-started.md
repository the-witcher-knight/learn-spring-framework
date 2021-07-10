# Reactive programming

Reactive programming là một cách tiếp cận để viết phần mềm bao gồm I/O bất đồng bộ. I/O bất đồng bộ là một ý tưởng nhỏ làm thay đổi lớn cho ứng dụng. 
Giảm bớt việc sử dụng tài nguyên kém hiệu quả bằng cách thu hồi các tài nguyên không hoạt động khi chúng chờ đợi hoạt động I/O.
I/O bất đồng bộ đảo ngược thiết kế thông thường của quá trình xử lý I/O: client được thông báo về dữ liệu mới thay vì yêu cầu nó; điều này cho phép client làm những việc khác trong khi chờ thông báo mới.

Ví dụ I/O bất đồng bộ

```java
// asynchronously
package com.example.io;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Log4j2
class Asynchronous implements Reader, CompletionHandler<Integer, ByteBuffer> {

    private int bytesRead;
    private long position;
    private AsynchronousFileChannel fileChannel;
    private Consumer<BytesPayload> consumer;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void read(File file, Consumer<BytesPayload> c) throws IOException {
        this.consumer = c;
        // chuyển đổi java.io.File sang Java NIO java.nio.file.Path
        Path path = file.toPath(); 
        // Khi tạo Channel, t chỉ định một java.util.concurrent.ExecutorService
        // sẽ được sử dụng để gọi CompleteHandler khi dữ liệu available
        this.fileChannel = AsynchronousFileChannel.open(path,
            Collections.singleton(StandardOpenOption.READ), this.executorService); 
        ByteBuffer buffer = ByteBuffer.allocate(FileCopyUtils.BUFFER_SIZE);
        // Bắt đầu đọc và chuyển tham chiếu đến
        // CompletionHandler<Integer, ByteBuffer> (this)
        this.fileChannel.read(buffer, position, buffer, this); 
        while (this.bytesRead > 0) {
                this.position = this.position + this.bytesRead;
                this.fileChannel.read(buffer, this.position, buffer, this);
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // trong callback, t đọc các byte trong ByteBuffer vào một byte[]
        this.bytesRead = result;

        if (this.bytesRead < 0)
            return;

        buffer.flip();

        byte[] data = new byte[buffer.limit()];
        buffer.get(data);

        // dữ liệu byte[] được chuyển cho consumer
        consumer.accept(BytesPayload.from(data, data.length));

        buffer.clear();

        this.position = this.position + this.bytesRead;
        this.fileChannel.read(buffer, this.position, buffer, this);
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        log.error(exc);
    }
}
```
