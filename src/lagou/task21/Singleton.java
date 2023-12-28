package lagou.task21;

// 单例设计模式
// 懒汉式的线程同步实现
public class Singleton {
    // 2. 申明本类型的引用只想本类型的对象，并用private static关键字修饰
    // volatile 关键字 参考文章中的单例模式解释 https://blog.csdn.net/u012723673/article/details/80682208
    private static volatile Singleton singleton = null;
    // 1. 私有化构造方法，使用private关键字修饰
    private Singleton(){}
    // 3. 提供公有的get方法将上述对象返回,使用private static
    // // 多线程时会出现new多个对象的问题，所以追加synchronized异步锁

    // 初始写法
    // public static /*synchronized*/ Singleton getInstance() {
    //     synchronized (Singleton.class) {
    //         if(singleton == null) singleton = new Singleton();
    //     }
    //     return singleton;
    // }

    // 优化写法 双重锁  只有第一次执行时需要加锁，之后每次均返回对象，无需加锁
    public static  Singleton getInstance() {
        if(singleton == null){
            synchronized (Singleton.class) {
                if(singleton == null) singleton = new Singleton();
            }
        }
        return singleton;
    }

    public void doSomething() {
        // ....
    }
}
