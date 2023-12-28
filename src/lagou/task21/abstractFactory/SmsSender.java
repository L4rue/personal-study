package lagou.task21.abstractFactory;

public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("SmsSender");
    }
}
