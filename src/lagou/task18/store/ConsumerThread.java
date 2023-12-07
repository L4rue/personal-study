package lagou.task18.store;

public class ConsumerThread extends Thread{
    // 申明一个仓库类的引用作为成员变量，是为了调用仓库类中的生产方法，   合成复用原则
    private Store store;

    public ConsumerThread(Store store,String name) {
        this.store = store;
        this.setName(name);
    }
    @Override
    public void run() {
        while (true) {
            // 消费产品1
            store.consume1();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
