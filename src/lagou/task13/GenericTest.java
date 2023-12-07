package lagou.task13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericTest {
    public static void main(String[] args) {
        List<Animal> l1 = new ArrayList<>();
        List<Dog> l2 = new ArrayList<>();
        // l1 = l2 // error

        System.out.println("-------------------------------------");
        // 范型通配符
        List<?> l3 = new ArrayList<>();
        l3 = l1; // 可以发生List<Animal>类型到List<?>类型的转换
        l3 = l2; // 可以发生List<Dog>类型到List<?>类型的转换
        // 向公共父类中添加元素和获取元素
        // l3.add(new Animal()); //error // 不能存放Animal类型的对象
        // l3.add(new Dog()); //error 不能存放Dog类型的对象，不支持元素的添加操作
        Object o = l3.get(0); // 支持元素的读取，均认为是Object类型

        System.out.println("-------------------------------------");
        // 有限制通配符
        List<? extends Animal> l4 = new ArrayList<>();
        // l4.add(new Animal()); // error
        // l4.add(new Dog()); // error 不支持元素的添加
        Animal a = l4.get(0);

        System.out.println("-------------------------------------");
        // 有限制通配符
        List<? super Animal> l5 = new ArrayList<>();
        l5.add(new Animal());
        l5.add(new Dog());
        // l5.add(new Object()); // error 超过Animal的范围
        Object o2 = l5.get(0);

    }
}
