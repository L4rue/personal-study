package lagou.task21.abstractFactory;

public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("MailSender");
    }
}
