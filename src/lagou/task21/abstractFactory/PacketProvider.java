package lagou.task21.abstractFactory;

public class PacketProvider implements Provider{
    @Override
    public Sender produce() {
        return new PacketSender();
    }
}
