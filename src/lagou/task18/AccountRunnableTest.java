package lagou.task18;

import java.util.concurrent.locks.ReentrantLock;

public class AccountRunnableTest {

     static class AccountRunnableImpl implements Runnable {
        /** 账户余额 */
        private Integer balance;

        private final Block block = new Block();

        private ReentrantLock lock = new ReentrantLock();

        public AccountRunnableImpl() {
        }

        public AccountRunnableImpl(Integer balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(Integer balance) {
            this.balance = balance;
        }

        @Override
        public /*synchronized*/ void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"已启动");
            // 开始加锁
            lock.lock();
            // synchronized (this) { // ok
            // synchronized (block) { // ok
            // synchronized (new Block()) {  // 锁不住
                // 1. 模拟后台查询账户余额
                int temp =getBalance();
                // 2. 模拟取款200
                if(temp > 200) {
                    System.out.println("正在出钞200元");
                    temp = temp -200;
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
                setBalance(temp);
            // }
            // 开始解锁
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        AccountRunnableImpl art = new AccountRunnableImpl(1000);
        System.out.println("现存余额："+art.getBalance());
        Thread t1 = new Thread(art);
        Thread t2 = new Thread(art);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("现存余额："+art.getBalance());  // 多线程共享资源
    }
}

class Block {}