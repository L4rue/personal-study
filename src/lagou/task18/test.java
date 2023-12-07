package lagou.task18;

public class test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        ThreadTest threadTest = new ThreadTest();
        // threadTest.run();
        threadTest.start();

        // for (int i = 0; i < 30; i++) {
        //     System.out.println("------------------"+i);
        // }

        Thread thread = new Thread(new RunnableTest());
        thread.start();

        // 使用继承+匿名内部类的方式创建线程
        /*Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println("---------"+i);
                }
            }
        };
        t1.start();*/
        // new Thread() {
        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 30; i++) {
        //             System.out.println("---------"+i);
        //         }
        //     }
        // }.start();
        // // 实现接口+匿名内部类的方式创建线程
        // Thread t2 = new Thread(() -> {
        //     System.out.println("匿名内部类");
        //     for (int i = 0; i < 30; i++) {
        //         System.out.println("---------"+i);
        //     }
        // });
        // t2.start();
    }
}
