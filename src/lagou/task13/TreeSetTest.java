package lagou.task13;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> s1 = new TreeSet<>();
        s1.add("aa");
        System.out.println(s1);
        s1.add("cc");
        System.out.println(s1);
        s1.add("bb");
        System.out.println(s1);

        Set<Student> s2 = new TreeSet<>();
        s2.add(new Student("刘备", 40));
        s2.add(new Student("关羽", 35));
        s2.add(new Student("张飞", 30));
        System.out.println(s2);

        // 传入的比较器优先于类内部实现的比较器
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) { // o1 表示新增加的对象，o2表示既存的对象
                return o2.getAge().compareTo(o1.getAge());
            }
        };
        Set<Student> s3 = new TreeSet<>(comparator);
        // lambda 表达式
        // Set<Student> s3 = new TreeSet<>((o1, o2) -> o2.getAge().compareTo(o1.getAge()));
        s3.add(new Student("刘备", 40));
        s3.add(new Student("张飞", 30));
        s3.add(new Student("关羽", 35));
        System.out.println(s3);

    }
}
