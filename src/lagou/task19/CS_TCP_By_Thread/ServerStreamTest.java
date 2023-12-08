package lagou.task19.CS_TCP_By_Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStreamTest {
    public static void main(String[] args) {
        // 1.创建serverSocket对象并监听端口号
        ServerSocket ss = null;
        Socket s = null;

        try {
            ss = new ServerSocket(8888);
            // 2.等待客户端的连接请求，调用accept方法
            System.out.println("等待客户端连接");
            while (true) {
                // 当没有客户端连接时，则阻塞在这里
                s = ss.accept();
                System.out.println("客户端" + s.getInetAddress() + "连接成功");
                new Thread(new ServiceStreamRunnable(s)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4.关闭Socket并释放资源
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
