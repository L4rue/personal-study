package lagou.task18;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        Thread.currentThread().setName("RunnableTest");
        System.out.println(Thread.currentThread().getName());
        // for (int i = 0; i < 100; i++) {
        //     System.out.println("-----"+i);
        // }
    }
}
