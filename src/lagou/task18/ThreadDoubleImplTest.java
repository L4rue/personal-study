package lagou.task18;

public class ThreadDoubleImplTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i=i+2) {
                System.out.println("---偶数: "+i);
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 1; i < 100; i=i+2) {
                System.out.println("-------奇数: "+i);
            }
        });

        t1.start();
        t2.start();

        System.out.println("开始等待");
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束");
    }
}
