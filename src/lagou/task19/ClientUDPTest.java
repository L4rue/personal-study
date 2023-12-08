package lagou.task19;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class ClientUDPTest {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] data = new byte[32];
        try {
            // 1. 创建DatagramSocket类型对象，并提供端口
            ds = new DatagramSocket();
            // 2. DatagramPacket类型对象，并提供缓冲区
            data = "Hello".getBytes(StandardCharsets.UTF_8);
            dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888);
            // 3. 通过Socket接受数据内容
            System.out.println("发送数据...");
            ds.send(dp);
            System.out.println("发送成功");
            // System.out.println("接受到的数据为："+ new String(data));
            data = new byte[32];
            dp = new DatagramPacket(data, data.length);
            ds.receive(dp);
            System.out.println("接受到的数据为：" + new String(data));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 关闭Socket
            if (ds != null) {
                ds.close();
            }
        }
    }
}
