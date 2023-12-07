package lagou.task18;

public class ThreadCommunicateTest implements Runnable {
    private int cnt = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();  // 唤醒其他线程任意一个线程
                if (cnt <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + ": " + cnt++);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        wait(); // 本线程进入阻塞
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadCommunicateTest tct = new ThreadCommunicateTest();
        Thread t1 = new Thread(tct);
        Thread t2 = new Thread(tct);
        t1.start();
        t2.start();
    }
}
