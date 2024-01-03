package lagou.old;

import java.util.Scanner;

public class StringMethodTest {
    public static void main(String[] args) {
        String str1 = "     let me give you some color to see!";
        boolean b1 =str1.contains("s");
        System.out.println(b1);
        System.out.println(str1.toUpperCase());
        System.out.println(str1);
        System.out.println(str1.indexOf('l'));

        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        String password = sc.next();

        if("admin".equals(username) && "123456".equals(password)) {
            System.out.println("pass");
        } else {
            System.out.println("err");
        }
        sc.close();
    }
}
