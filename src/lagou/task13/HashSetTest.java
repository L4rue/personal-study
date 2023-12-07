package lagou.task13;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {

        Set<String> s1 = new HashSet<>(); // one two three
        // Set<String> s1 = new LinkedHashSet<>(); // two one three
        s1.add("two");
        s1.add("one");
        s1.add("three");
        s1.add("one");
        Set<String > s2 = new LinkedHashSet<>(s1);
        System.out.println(s1);
        System.out.println(s2);

    }
}
