package lagou.task18.store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        ProduceThread pt1 = new ProduceThread(store,"生产者1 ");
        ConsumerThread ct1 = new ConsumerThread(store,"消费者1");
        Thread pt2 = new Thread(new ProduceRunnable(store),"生产者2 ");
        Thread ct2 = new Thread(new ConsumerRunnable(store),"消费者2");

        pt1.start();
        ct1.start();
        pt2.start();
        ct2.start();
    }
}
