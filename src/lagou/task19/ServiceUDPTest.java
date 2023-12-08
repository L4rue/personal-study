package lagou.task19;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServiceUDPTest {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] data = new byte[32];
        try {
            // 1. 创建DatagramSocket类型对象，并提供端口
            ds = new DatagramSocket(8888);
            // 2. DatagramPacket类型对象，并提供缓冲区
            dp = new DatagramPacket(data, data.length);
            // 3. 通过Socket接受数据内容
            System.out.println("等待数据...");
            ds.receive(dp);
            System.out.println("接受到的数据为：" + new String(data));
            dp = new DatagramPacket(data, data.length, dp.getAddress(), dp.getPort());
            ds.send(dp);
            System.out.println("回发数据成功");
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
