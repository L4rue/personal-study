package lagou.task21.Decorator;

public class SourceableTest {
    public static void main(String[] args) {
        // 使用原类
        Sourceable sourceable = new Source();
        sourceable.method();

        System.out.println("-------------------------------");
        // 使用装饰器
        Sourceable sourceable1 = new Decorator(sourceable);
        sourceable1.method();
    }
}
