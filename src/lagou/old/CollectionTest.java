package lagou.old;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Object> c1 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            c1.add(0,1);
        }
        System.out.println(System.nanoTime()-startTime);
        startTime = System.nanoTime();
        List<Object> c2 = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            c2.add(0,1);
        }
        System.out.println(System.nanoTime()-startTime);
        c2.add(123);

    }
}
