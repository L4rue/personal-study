package lagou.task21.factory;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("MailSender");
    }
}
