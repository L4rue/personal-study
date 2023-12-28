package lagou.task20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PersonFieldTest {
    public static void main(String[] args) throws Exception {
        // 1.使用原始方式来构造对象以及获取成员变量的数值并打印
        Person p1 = new Person("zhangfei",34);
        // private 不可访问
        // System.out.println("获取的成员变量数值为："+p1.name);

        // 2. 使用反射机制构造对象以及获取成员变量的数值并打印
        // 2.1 获取Class对象
        Class c1 = Class.forName("lagou.task20.Person");
        // 2.2 根据class对象来获取对应的有参构造方法
        Constructor constructor = c1.getConstructor(String.class,int.class);
        // 2.3 使用有参构造方法来得到Person类型的对象
        Object o = constructor.newInstance("zhangfei", 34);
        // 2.4 根据Class对象类获取对应的成员变量信息
        Field field = c1.getDeclaredField("name");
        field.setAccessible(true);  // 访问private成员
        // 2.5 使用Person类型的对象来获取成员变量的数值并打印
        System.out.println("获取的成员变量数值为："+field.get(o));

        // 3. 修改成员变量的数值后打印
        System.out.println("修改前为："+field.get(o));
        field.set(o,"guanyu");
        System.out.println("修改后为："+field.get(o));


        // 4. 获取class对象对应类中所有的成员变量
        System.out.println("---------------------------");
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field field1:declaredFields) {
            System.out.println("成员变量的访问修饰符是："+field1.getModifiers());
            System.out.println("成员变量的类型是："+field1.getType());
            System.out.println("成员变量的名称是："+field1.getName());
            System.out.println("--------------------");

        }
    }
}
