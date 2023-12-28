package lagou.task21.staticFactory;

// 普通工厂模式创建对象
public class SendFactoryTest {
    public static void main(String[] args) {

        Sender sender = SendFactory.produce("mail");
        sender.send();

        Sender sender3 = SendFactory.produceMail();
        sender3.send();

        Sender sender2 = SendFactory.produce("sms");
        sender2.send();

        System.out.println("-----------------");
        MailSender ms = new MailSender();
        ms.send();
    }
}
