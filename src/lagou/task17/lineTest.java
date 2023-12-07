package lagou.task17;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class lineTest {
    public static void main(String[] args) {
        PrintStream ps = null;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(System.in));
            ps = new PrintStream(new FileOutputStream("src/lagou/task17/2.txt"));
            boolean flag = true;
            while (true) {
                // 1.输入聊天内容
                System.out.println("请输入聊天内容");
                // 查文档可知，BufferedReader的参数是Reader抽象类，只能传递其子类对象，是字符流
                // System.in代表键盘输入，是InputStream类型，字节流
                // 即需要实现字节流到字符流的转换
                String str = null;
                str = bf.readLine();
                // 2.判断用户输入内容是否为 bye ，是则结束聊天
                if ("bye".equals(str)) {
                    System.out.println("聊天结束");
                    break;
                }
                // 3.否则输出聊天内容
                else {
                    String date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
                    ps.println(date + (flag?" 张三说：":" 李四说：")+ str);
                    flag = !flag;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
