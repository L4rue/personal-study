package lagou.task21.abstractFactory;

public class MailSendFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
