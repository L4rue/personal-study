package lagou.task21.abstractFactory;

// 抽象工厂模式创建对象
public class SendFactoryTest {
    public static void main(String[] args) {
        // 1. 创建工厂类的对象
        Provider provider = new MailSendFactory();
        // 2. 调用生产方法
        Sender sender = provider.produce();
        // 3. 使用对象的send方法
        sender.send();

        // 1. 创建工厂类的对象
        Provider provider2 = new SmsSendFactory();
        // 2. 调用生产方法
        Sender sender2 = provider2.produce();
        // 3. 使用对象的send方法
        sender2.send();

        // 来了新需求，可以直接追加新的实现，不需要动上面两个实现的代码，符合开闭原则
        // 1. 创建工厂类的对象
        Provider provider3 = new PacketProvider();
        // 2. 调用生产方法
        Sender sender3 = provider3.produce();
        // 3. 使用对象的send方法
        sender3.send();


    }
}
