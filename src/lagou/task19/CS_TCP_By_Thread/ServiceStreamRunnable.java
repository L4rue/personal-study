package lagou.task19.CS_TCP_By_Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServiceStreamRunnable implements Runnable {

    Socket s;

    public ServiceStreamRunnable(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintStream ps = null;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());
            while (true) {
                // 3.使用输入输出流通信
                // 当没有数据发送时，产生阻塞
                String str = br.readLine();
                System.out.println("客户端发送的字符串为：" + str);

                if (str == null || "bye".equals(str)) {
                    ps.println("bye");
                    System.out.println("客户端" + s.getInetAddress() + "已下线");
                    break;
                } else {
                    ps.println("收到了,你发的是: " + str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
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
        }
    }
}
