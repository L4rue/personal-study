package lagou.task23.Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorServerTest {
    public static void main(String[] args) {

        Selector selector = null;
        ServerSocketChannel serverSocketChannel1 = null;
        ServerSocketChannel serverSocketChannel2 = null;
        ServerSocketChannel serverSocketChannel3 = null;
        try {
            // 1. 获取selector对象
            selector = Selector.open();
            // 2. 获取通道
            serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel3 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress(9999));
            serverSocketChannel2.bind(new InetSocketAddress(8888));
            serverSocketChannel3.bind(new InetSocketAddress(7777));

            // 3. 设置为非阻塞 ⭐️ 与select对象一起使用时，必须处于非阻塞状态下，如果是阻塞的，会抛出异常
            serverSocketChannel1.configureBlocking(false);
            serverSocketChannel2.configureBlocking(false);
            serverSocketChannel3.configureBlocking(false);
            // 4. 把通道注册到selector上,指定监听事件为“ACCEPT”事件,即发生ACCEPT事件时，会触发响应
            serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
            serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
            serverSocketChannel3.register(selector, SelectionKey.OP_ACCEPT);
            // 5. 轮询，等待有事件到来,select()的返回值表示有多少通道已经就绪(收到监听的事件)
            // 阻塞到至少有一个通道上的事件就绪
            System.out.println("waiting...");
            while (selector.select() > 0) {
                // 6. 获取所有就绪的通道，selectedKeys()返回值是所有准备就绪的通道
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 7. 遍历
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    // 8. 判断事件类型
                    System.out.println("---------------------------------");
                    System.out.println(selectionKey.isAcceptable()); // true，表示是Accept事件触发了响应
                    // 9. 接收客户端数据
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = channel.accept();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len = socketChannel.read(byteBuffer);
                    // 10.打印
                    System.out.println(new String(byteBuffer.array(), 0, len));
                    // 11.关闭socketChannel
                    socketChannel.close();
                    // 12. 从集合中删除已处理的事件
                    // https://blog.csdn.net/qq_32331073/article/details/81132937
                    // https://cloud.tencent.com/developer/article/1894102
                    iterator.remove();
                    System.out.println(selectionKeys.size());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (serverSocketChannel1 != null) {
                    serverSocketChannel1.close();
                }
                if (serverSocketChannel2 != null) {
                    serverSocketChannel2.close();
                }
                if (serverSocketChannel3 != null) {
                    serverSocketChannel3.close();
                }
                if (selector != null) {
                    selector.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
