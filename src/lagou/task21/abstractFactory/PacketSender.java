package lagou.task21.abstractFactory;

public class PacketSender implements Sender{
    @Override
    public void send() {
        System.out.println("PacketSender");
    }
}
