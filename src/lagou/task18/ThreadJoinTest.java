package lagou.task18;

public class ThreadJoinTest extends Thread{
    @Override
    public void run() {
        System.out.println("倒计时开始");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadJoinTest tjt = new ThreadJoinTest();
        tjt.start();
        try {
            // / 表示当前正在执行的线程对象等待调用线程对象，也就是
            tjt.join(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("新年快乐！");
    }
}
