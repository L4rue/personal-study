package lagou.task18;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1.创建线程池
        // ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(5);
        // 2.下发任务
        Future obj = es.submit(new ThreadCallableTest());
        try {
            System.out.println(obj.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        // 3.关闭线程池
        es.shutdown();

    }
}
