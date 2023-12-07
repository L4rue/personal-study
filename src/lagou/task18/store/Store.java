package lagou.task18.store;

/**
 * 仓库类
 */
public class Store {
    private  int cnt1 = 0;
    private  int cnt2 = 0;

    public synchronized void produce1() {
        notify();
        if(cnt1+cnt2 < 10) {
            cnt1++;
            System.out.println(Thread.currentThread().getName()+"正在生产第"+cnt1+"个产品1...");
        } else {
            try {
                System.out.println("不需要生产1");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void produce2() {
        notify();
        if(cnt1+cnt2 < 10) {
            cnt2++;
            System.out.println(Thread.currentThread().getName()+"正在生产第"+cnt2+"个产品2...");
        } else {
            try {
                System.out.println("不需要生产2");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consume1() {
        notify();
        if(cnt1 > 0) {
            System.out.println(Thread.currentThread().getName()+"消费了第"+cnt1+"个产品1");
            cnt1--;
        } else {
            try {
                System.out.println("没有产品1了");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void consume2() {
        notify();
        if(cnt2 > 0) {
            System.out.println(Thread.currentThread().getName()+"消费了第"+cnt2+"个产品2");
            cnt2--;
        } else {
            try {
                System.out.println("没有产品2了");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
