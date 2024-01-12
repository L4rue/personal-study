package lagou.task23.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * BIO：同步阻塞  NIO：同步非阻塞（并发支持高）
 */
public class NIO_TCP_Server_Test {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;
        try {
            // 1.创建ServerSocketChannel
            serverSocketChannel = ServerSocketChannel.open();
            // 2.绑定需要监听的端口
            serverSocketChannel.bind(new InetSocketAddress(9999));
            while (true) {
                System.out.println("wait client connect...");
                // 3.等待客户端连接
                serverSocketChannel.configureBlocking(false); // false设置为非阻塞，true为阻塞
                socketChannel = serverSocketChannel.accept();
                // 由于accept非阻塞，如果没有客户端连接，会返回null，需要判空
                if (socketChannel == null) {
                    TimeUnit.SECONDS.sleep(2);
                    continue;
                }
                System.out.println("client " + socketChannel.socket().getInetAddress() + " connected!");
                // 4.读取数据
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len = socketChannel.read(byteBuffer);
                // 5.打印数据
                // System.out.println(new String(byteBuffer.array()));// hello口口口口...(空格）
                System.out.println(new String(byteBuffer.array(), 0, len));// hello
                TimeUnit.SECONDS.sleep(2);
                byteBuffer.clear();
                byteBuffer.put("me too".getBytes());
                socketChannel.write(byteBuffer.flip());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 6.关闭通道
            try {
                socketChannel.close();
                serverSocketChannel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
