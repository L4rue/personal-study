package lagou.task18;

public class ThreadDaemonTest extends Thread{
    @Override
    public void run() {
        System.out.println(isDaemon()?"是守护线程":"不是守护线程");  // 默认不是守护线程
        // 当子线程不是守护线程的时候，主线程结束，子线程会继续执行
        // 当子线程是守护线程的时候，主线程结束，子线程结束
        for (int i = 0; i < 50; i++) {
            System.out.println("子线程："+i);
        }
    }

    public static void main(String[] args) {
        ThreadDaemonTest tdt = new ThreadDaemonTest();
        tdt.setDaemon(true);
        tdt.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("--------主线程："+i);
        }
    }
}
