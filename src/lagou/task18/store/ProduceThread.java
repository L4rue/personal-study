package lagou.task18.store;

/**
 * 生产者线程
 */
public class ProduceThread extends Thread{
    // 申明一个仓库类的引用作为成员变量，是为了调用仓库类中的生产方法，   合成复用原则
    private Store store;

    public ProduceThread(Store store,String name) {
        this.store = store;
        this.setName(name);
    }
    @Override
    public void run() {
        while (true) {
            // 生产产品1
            store.produce1();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
