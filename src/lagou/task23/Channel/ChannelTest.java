package lagou.task23.Channel;

import java.io.IOException;

/**
 * channel通道
 * channel表示IO源与目标打开的连接，类似于“流”，但是是双向的
 * NIO是基于channel（通道）和buffer（缓冲区）进行读写，数据总是从channel读入buffer，或者从buffer写入channel
 * <p>
 * FileChannel          本地资源的读写通道<br>
 * DatagramChannel      通过UDP读写网络中的数据通道<br>
 * SocketChannel        通过TCP读写网络中的数据通道<br>
 * ServerSocketChannel  监听新建的TCP连接，对每一个新TCP连接都会创建一个SocketChannel<br>
 */
public class ChannelTest {
    public static void main(String[] args) {
        try {
            FileChannelTest.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
