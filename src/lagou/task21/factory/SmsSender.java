package lagou.task21.factory;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("SmsSender");
    }
}
