package lagou.task23.Selector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIO_TCP_Client_Test2 {
    public static void main(String[] args) {
        SocketChannel soc = null;
        try {
            // 1.创建SocketChannel
            soc = SocketChannel.open();
            soc.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

            // 2.创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            // 3.写入数据并发送
            byteBuffer.put("port 8888 send message".getBytes());
            // ⭐️必须重置position和limit位置，否则会传输position之后的空数据，详见BufferTest里面的示例
            byteBuffer.flip();
            soc.write(byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4.关闭通道
            if (soc != null) {
                try {
                    soc.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
