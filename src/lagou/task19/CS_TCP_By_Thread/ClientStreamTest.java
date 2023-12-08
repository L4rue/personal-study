package lagou.task19.CS_TCP_By_Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStreamTest {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        BufferedReader br = null;
        try {
            // 1.创建Socket对象并提供服务器通信地址
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功");
            Scanner sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {
                // 2.使用输入输出流进行通信
                // Thread.sleep(10000);
                System.out.println("请输入发送的内容");

                String str = sc.next();
                ps.println(str);

                String res = br.readLine();
                System.out.println("服务器回答：" + res);
                if ("bye".equals(res)) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (s != null) {
                // 3.关闭Socket对象并释放资源
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
