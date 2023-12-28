package lagou.task20;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {

        // 1.使用数据类型.class的方式可以获取对应类型的class对象
        Class c1 = String.class;
        System.out.println(c1); //  class java.lang.class
        Class c2 = int.class;
        System.out.println(c2); // int
        Class c3 = void.class;
        System.out.println(c3); // void

        // 2.使用对象.getClass()的方式获取对应的class对象
        String str1 = new String("hello");
        c1 = str1.getClass();
        System.out.println(c1); // class java.lang.String

        Integer i1 = 20;
        System.out.println(i1.getClass()); // class java.lang.Integer

        // 3.使用包装类.TYPE的方式获取对应的基本数据类型
        c1 = Integer.TYPE;
        System.out.println(c1);  // int

        c1 = Integer.class;
        System.out.println(c1);  // class java.lang.Integer

        // 4.调用class类中的forName方法获取对应的class对象
        // c1 = Class.forName("String");
        // System.out.println(c1); // error ClassNotFoundException

        c1 = Class.forName("java.lang.String");
        System.out.println(c1); // class java.lang.String

        c1 = Class.forName("java.util.Date");
        System.out.println(c1); // class java.util.Date

        // c1 = Class.forName("int"); //error ClassNotFoundException  不能获取基本数据类型的Class对象

        // 5. 使用类加载器的方式获取Class对象
        // ClassLoader classLoader = String.class.getClassLoader();
        // c1 = classLoader.getClass(); // error NPE

        ClassLoader classLoader = ClassTest.class.getClassLoader();
        c1 = classLoader.loadClass("java.lang.String");

        System.out.println(c1); // class java.lang.String
        c1 = classLoader.getClass();
        System.out.println(c1); // class jdk.internal.loader.ClassLoaders
    }
}
