package lagou.task22;

import java.util.ArrayList;
import java.util.List;

public class varTest {
    public static void main(String[] args) {
        // 由初始值可以推断出变量的类型，因此可以使用var取代
        // int num = 10;
        var num = 10;

        // List<Integer> list = new ArrayList<>();
        var list = new ArrayList<Integer>();

        for (var i = 0; i < 10; i++) {
            list.add(i);
        }

        for (var i : list) {
            System.out.println(i);
        }

        // 注意：var不是关键字！
        int var = 100;
    }
}
