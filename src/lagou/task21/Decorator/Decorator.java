package lagou.task21.Decorator;

public class Decorator implements Sourceable{
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = new Source();
    }

    @Override
    public void method() {
        source.method(); // 代理执行原类
        System.out.println("新增功能"); // 追加了新功能
    }
}
