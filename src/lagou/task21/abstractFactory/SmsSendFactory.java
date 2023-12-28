package lagou.task21.abstractFactory;

public class SmsSendFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
