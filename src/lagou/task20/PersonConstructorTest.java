package lagou.task20;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

public class PersonConstructorTest {
    public static void main(String[] args) throws Exception {
        // 使用无参方式构造Person类型的对象并打印
        Person p1 =new Person();
        String name = p1.getName();
        System.out.println("无参方式构造对象为" +p1);

        // ---------------newInstance()---------已弃用-----

        // 使用反射机制以无参方式构造Person类并打印
        Class c1 = Class.forName("lagou.task20.Person");
        System.out.println(c1.newInstance().toString());

        // System.out.println("请输入创作对象的内容"); //  lagou.task20.Person
        // Scanner sc = new Scanner(System.in);
        // String str1 = sc.next();
        // Class c2 = Class.forName(str1);
        // System.out.println(c2.newInstance().toString());

        // 创建对象的类型可以从配置文件里读取
        BufferedReader br = new BufferedReader(new FileReader("src/lagou/task20/mojo.properties"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/lagou/task20/mojo.properties")));
        String str1 = br.readLine();
        Class c3 = Class.forName(str1);
        System.out.println(c3.newInstance().toString());
        br.close();

        // ---------------newInstance()---------已弃用-----

        // ---------------Constructor--------------
        Class c4 = Class.forName("lagou.task20.Person");
        Constructor constructor = c4.getConstructor();
        // 无参方式创建对象
        System.out.println(constructor.newInstance());

        // 有参方式创建对象  常规
        Person p2 = new Person("zhangfei",34);
        System.out.println(p2);

        // 有参方式创建对象  Constructor
        Constructor constructor2 = c4.getConstructor(String.class,int.class);
        System.out.println(constructor2.newInstance("zhangfei",34));
        Person p3 = (Person) constructor2.newInstance("zhangfei",34);
        System.out.println(p3);

        // 获取所有的公共构造函数
        System.out.println("---------------------------------------");
        Constructor[] constructors = c4.getConstructors();
        for(Constructor item : constructors) {
            System.out.println("构造函数的访问修饰符是："+item.getModifiers());
            System.out.println("构造函数的方法名称是："+item.getName());
            Class[] parameters = item.getParameterTypes();
            System.out.println("此构造函数的所有参数类型是：");
            for (Class para:parameters) {
                System.out.print(para+",");
            }
            System.out.println("---------------------------------------");
        }

    }
}
