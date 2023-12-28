package lagou.task21.Proxy;

public class SourceableTest {
    public static void main(String[] args) {
        // 使用代理类
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
