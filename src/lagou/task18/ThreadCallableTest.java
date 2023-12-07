package lagou.task18;

import java.util.concurrent.*;

public class ThreadCallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        // 计算1-10000累加
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        ThreadCallableTest tct = new ThreadCallableTest();
        FutureTask ft = new FutureTask<>(tct);
        Thread t1 = new Thread(ft);
        t1.start();
        Object obj;
        try {
            obj = ft.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(obj);

    }
}
