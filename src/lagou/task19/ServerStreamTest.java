package lagou.task19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStreamTest {
    public static void main(String[] args) {
        // 1.创建serverSocket对象并监听端口号
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader br = null;
        PrintStream ps = null;
        try {
            ss = new ServerSocket(8888);
            // 2.等待客户端的连接请求，调用accept方法
            System.out.println("等待客户端连接");
            // 当没有客户端连接时，则阻塞在这里
            s = ss.accept();
            System.out.println("客户端连接成功");
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());
            while (true) {
                // 3.使用输入输出流通信
                // 当没有数据发送时，产生阻塞
                String str = br.readLine();
                System.out.println("客户端发送的字符串为：" + str);

                if (str == null || "bye".equals(str)) {
                    ps.println("bye");
                    System.out.println("客户端已下线");
                    break;
                } else {
                    ps.println("收到了,你发的是: " + str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4.关闭Socket并释放资源
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ps != null) {
                ps.close();
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (s != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
