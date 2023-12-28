package lagou.task20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonMethodTest {
    public static void main(String[] args) throws Exception {
        // 1. 使用反射机制构造对象并调用方法打印结果
        // 1.1 获取Class对象
        Class c1 = Class.forName("lagou.task20.Person");
        // 1.2 根据class对象来获取对应的有参构造方法
        Constructor constructor = c1.getConstructor(String.class,int.class);
        // 1.3 使用有参构造方法来得到Person类型的对象
        Object o = constructor.newInstance("zhangfei", 34);
        // 1.4 根据class对象来获取对应的成员方法
        Method method = c1.getMethod("getName");
        // 1.5 使用对象调用成员方法进行打印
        System.out.println("调用方法的返回值是：" +method.invoke(o));

        // 2. 使用反射机制获取类中的所有方法并
        System.out.println("------------------------------------------------");
        Method[] methods = c1.getMethods();
        for (Method method1 : methods) {
            System.out.println("方法名为："+method1.getName());
            System.out.println("修饰符为："+method1.getModifiers());
            System.out.println("返回类型为："+method1.getReturnType());
            System.out.println("参数类型为："+ Arrays.toString(method1.getParameterTypes()));
            System.out.println("异常类型为："+ Arrays.toString(method1.getExceptionTypes()));
            System.out.println("---------------");
            // method1.invoke(o);

        }
    }
}
