package lagou.task21.Proxy;

public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void method() {
        source.method(); // 代理执行原类
        System.out.println("新增功能"); // 追加了新功能
    }
}
