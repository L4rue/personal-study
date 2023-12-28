package lagou.task21.Decorator;

public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("原有功能");
    }
}
