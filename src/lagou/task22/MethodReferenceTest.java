package lagou.task22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

// 方法引用实现函数式接口
public class MethodReferenceTest {
    public static void main(String[] args) {
        // 1. 使用匿名内部类的方式通过函数式接口Runnable中的方法实现Person类中show方法的调用
        Person person = new Person("zhangfei", 30);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                person.show();
            }
        };
        runnable.run();  // zhangfei 30

        // 2. 使用Lambda表达式的方式通过函数式接口Runnable中的方法实现Person类中show方法的调用
        Runnable runnable1 = () -> person.show();
        runnable1.run();  // zhangfei 30

        // 3. 使用方法引用的方式通过函数式接口Runnable中的方法实现Person类中show方法的调用
        Runnable runnable2 = person::show;
        runnable2.run();  // zhangfei 30

        System.out.println("-------------------------------");
        // 4. 使用匿名内部类的方式通过函数式接口Consumer中的方法实现Person类中setName方法的调用
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                person.setName(name);
            }
        };
        consumer.accept("guanyu");
        person.show();

        // 5. 使用Lambda表达式的方式通过函数式接口Consumer中的方法实现Person类中setName方法的调用
        Consumer<String> consumer1 = (name) -> person.setName(name);
        consumer1.accept("liubei");
        person.show();

        // 6. 使用方法引用的方式通过函数式接口Consumer中的方法实现Person类中setName方法的调用
        Consumer<String> consumer2 = person::setName;
        consumer2.accept("zhangfei");
        person.show();

        System.out.println("-------------------------------");
        // 7. 使用Lambda表达式的方式通过函数式接口Supplier中的方法实现Person类中getName方法的调用
        Supplier<String> supplier = () -> person.getName();
        System.out.println(supplier.get());

        // 8. 使用方法引用的方式通过函数式接口Supplier中的方法实现Person类中getName方法的调用
        Supplier<String> supplier1 = person::getName;
        System.out.println(supplier1.get());

        System.out.println("-------------------------------");
        // 9. 使用匿名内部类的方式通过函数式接口Function中的方法实现Integer类中parseInt方法的调用
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(function.apply("123"));

        // 10. 使用Lambda表达式的方式通过函数式接口Function中的方法实现Integer类中parseInt方法的调用
        Function<String, Integer> function0 = (s) -> Integer.parseInt(s);
        System.out.println(function0.apply("123"));

        // 11. 使用方法引用的方式通过函数式接口Function中的方法实现Integer类中parseInt方法的调用
        Function<String, Integer> function1 = Integer::parseInt;
        System.out.println(function1.apply("123"));

        System.out.println("-------------------------------");
        // 12. 使用匿名内部类的方式通过函数式接口Comparator中的方法实现Integer类中compare方法的调用
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(1, 2));

        // 13. 使用Lambda表达式的方式通过函数式接口Comparator中的方法实现Integer类中compare方法的调用
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(1, 2));

        // 14. 使用方法引用的方式通过函数式接口Comparator中的方法实现Integer类中compare方法的调用
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(1, 2));

        System.out.println("-------------------------------");
        // 15. 使用匿名内部类的方式通过类名来调用非静态方法
        // 其中一个参数对象作为调用对象来调用方法时，可以使用上述方式
        Comparator<Integer> comparator3 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator3.compare(1, 2));

        // 16. 使用Lambda表达式的方式通过类名来调用非静态方法
        Comparator<Integer> comparator4 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator4.compare(1, 2));

        // 17. 使用方法引用的方式通过类名来调用非静态方法
        Comparator<Integer> comparator5 = Integer::compareTo;
        System.out.println(comparator5.compare(1, 2));

        System.out.println("-------------------------------");
        // 18. 使用匿名内部类的方式通过Supplier函数式接口创建Person类型的对象并返回
        Supplier<Person> supplier2 = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(supplier2.get());

        // 19. 使用Lambda表达式的方式通过Supplier函数式接口创建Person类型的对象并返回
        Supplier<Person> supplier3 = () -> new Person();
        System.out.println(supplier3.get());

        // 20. 使用方法引用的方式通过Supplier函数式接口创建Person类型的对象并返回
        Supplier<Person> supplier5 = Person::new;
        System.out.println(supplier.get());

        System.out.println("-------------------------------");
        // 21. 使用匿名内部类的方式通过BiFunction函数式接口创建Person类型的对象
        BiFunction<String, Integer, Person> biFunction = new BiFunction<String, Integer, Person>() {
            @Override
            public Person apply(String name, Integer age) {
                return new Person(name, age);
            }
        };
        System.out.println(biFunction.apply("zhangfei", 30));

        // 22. 使用Lambda表达式的方式通过BiFunction函数式接口创建Person类型的对象
        BiFunction<String, Integer, Person> biFunction1 = (name, age) -> new Person(name, age);
        System.out.println(biFunction1.apply("zhangfei", 30));

        // 23. 使用方法引用的方式通过BiFunction函数式接口创建Person类型的对象
        BiFunction<String, Integer, Person> biFunction2 = Person::new;
        System.out.println(biFunction2.apply("zhangfei", 30));

        System.out.println("-------------------------------");
        // 24. 使用匿名内部类的方式通过Function函数式接口创建指定数量的Person类型的对象数组
        Function<Integer, Person[]> function2 = new Function<Integer, Person[]>() {
            @Override
            public Person[] apply(Integer num) {
                return new Person[num];
            }
        };
        System.out.println(Arrays.toString(function2.apply(3)));

        // 25. 使用Lambda表达式的方式通过Function函数式接口创建指定数量的Person类型的对象数组
        Function<Integer, Person[]> function3 = num -> new Person[num];
        System.out.println(Arrays.toString(function3.apply(3)));

        // 26. 使用方法引用的方式通过Function函数式接口创建指定数量的Person类型的对象数组
        Function<Integer, Person[]> function4 = Person[]::new;
        System.out.println(Arrays.toString(function4.apply(3)));

        // 27. BiPredicate练习
        System.out.println("-------------------------------");
        BiPredicate<Integer, Integer> biPredicate = (o1, o2) -> o1.compareTo(o2) > 0;
        System.out.println(biPredicate.test(1, 2)); // false
        System.out.println(biPredicate.or(biPredicate.negate()).test(1,2) ); // true

    }
}
