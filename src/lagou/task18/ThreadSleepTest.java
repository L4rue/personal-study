package lagou.task18;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ThreadSleepTest extends Thread {

    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("+8")).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleepTest tst = new ThreadSleepTest();
        tst.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tst.flag = false;
    }
}
