package lagou.task20;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class StudentTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c1 = Class.forName("lagou.task20.Student");
        System.out.println("包名为："+c1.getPackageName());
        System.out.println("父类为："+c1.getSuperclass());
        System.out.println("接口为："+ Arrays.toString(c1.getInterfaces()));
        System.out.println("注解为："+ Arrays.toString(c1.getAnnotations()));
        System.out.println("范型为："+ Arrays.toString(c1.getGenericInterfaces()));
    }
}
