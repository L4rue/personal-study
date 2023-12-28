package lagou.task21.staticFactory;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("SmsSender");
    }
}
