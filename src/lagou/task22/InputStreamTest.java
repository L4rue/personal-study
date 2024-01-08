package lagou.task22;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream f1 = new FileInputStream("src/lagou/task22/99_source.txt");
        OutputStream o1 = new FileOutputStream("src/lagou/task22/2.txt");
        f1.transferTo(o1); // Java 9 新特性，可以直接将流进行转换
        f1.close();
        File file = new File("src/lagou/task22/2.txt");
        if(file.exists()) {
            file.delete();
        }
        o1.close();

    }
}
