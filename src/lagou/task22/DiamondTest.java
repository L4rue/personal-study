package lagou.task22;

import java.util.Comparator;

public class DiamondTest {
    public static void main(String[] args) {
        // Comparator<Integer> comparator = new Comparator<Integer>() {
        // 钻石操作符（菱形操作符）可以省略一个Integer
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }
}
