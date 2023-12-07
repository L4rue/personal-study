package lagou.task18;

public class ThreadPriorityTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadPriorityTest tpt = new ThreadPriorityTest();
        tpt.setPriority(Thread.MAX_PRIORITY);
        tpt.start();

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 30; i++) {
            System.out.println("-----"+i);
        }
    }
}
