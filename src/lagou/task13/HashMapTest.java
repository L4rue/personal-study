package lagou.task13;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        System.out.println(m1); //{}
        m1.put("1", "one");
        System.out.println(m1); //{1=one}
        m1.put("2", "two");
        System.out.println(m1); //{1=one, 2=two}
        m1.put("3", "four");
        System.out.println(m1); //{1=one, 2=two, 3=four}
        m1.put("3", "three");
        System.out.println(m1); //{1=one, 2=two, 3=three}

        Set<Map.Entry<String, String>> entires = m1.entrySet();
        




    }
}
