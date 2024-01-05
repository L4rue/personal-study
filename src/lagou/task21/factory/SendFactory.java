package lagou.task21.factory;

// 普通工厂模式创建对象
public class SendFactory {
    // 自定义成员方法实现对象的创建
    public Sender produce(String type) {
        if("mail".equals(type)) {
            return new MailSender();
        }
        if("sms".equals(type)) {
            return new SmsSender();
        }
        return null;
    }
    public  Sender produceMail() {
        return new MailSender();
    }

    public  Sender produceSms() {
        return new SmsSender();
    }
}
