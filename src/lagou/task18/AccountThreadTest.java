package lagou.task18;

public class AccountThreadTest extends Thread {
    /**
     * 账户余额
     */
    private Integer balance;

    private static final Block block = new Block();  // 使用static对象，将block提升至class层级， 则可以保证多对象也可以线程同步

    public AccountThreadTest() {
    }

    public AccountThreadTest(Integer balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        test();
    }

    public /*synchronized*/ static void test() {
        System.out.println("线程" + Thread.currentThread().getName() + "已启动");
        synchronized (AccountThreadTest.class) { // ok

            // synchronized (block) { // ok
            // synchronized (new Block()) {  // 锁不住
            // 1. 模拟后台查询账户余额
            int temp = 1000;   // getBalance();
            // 2. 模拟取款200
            if (temp > 200) {
                System.out.println("正在出钞200元");

                temp = temp - 200;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("请取走钞票");
            } else {
                System.out.println("余额不足");
            }
            // 3. 模拟写入最新余额
            // setBalance(temp);
        }
    }

    public static void main(String[] args) {
        AccountThreadTest t1 = new AccountThreadTest(1000);
        AccountThreadTest t2 = new AccountThreadTest(1000);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // System.out.println("现存余额："+t1.getBalance());  // 多线程共享资源
        // System.out.println("现存余额："+t2.getBalance());  // 多线程共享资源
    }
}
