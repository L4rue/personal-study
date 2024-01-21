package lagou.task18;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        setName("ThreadTest");
        Thread.yield();
        // System.out.println("ThreadTest");
        System.out.println(getName());
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(i);
        // }
    }
}
