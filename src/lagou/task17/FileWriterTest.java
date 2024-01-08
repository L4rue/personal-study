package lagou.task17;

import java.io.*;

public class FileWriterTest {
    public static void main(String[] args) {
        try {
            // fileWrite();
            // fileReader();
            bufferCopy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void fileWrite() throws IOException {
        // 1. 打开文件
        FileWriter fw = new FileWriter("src/lagou/task17/99_source.txt", true);
        // 2. 写入
        for (int i = 0; i < 100000000; i++) {
            fw.write('a');
        }
        // fw.write('a');
        System.out.println("success");
        // 3. 关闭
        fw.close();
    }

    static void fileReader() throws IOException {
        // FileReader fr = new FileReader("src/lagou/task17/99_source.txt");
        // int res;
        // while ((res = fr.read()) != -1) {
        //     System.out.println((char) fr.read());
        // }
        // fr.close();
        FileReader fr = new FileReader("src/lagou/task17/99_source.txt");
        char[] resList = new char[1024];
        int res = fr.read(resList);
        System.out.println(res);
        for (char c : resList) {
            System.out.println(c);
        }
        System.out.println(" ");
    }

    static void bufferCopy() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/lagou/task17/99_source.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/lagou/task17/1_out.txt"));
        FileInputStream f1 = new FileInputStream("src/lagou/task17/99_source.txt");
        byte[] resList = new byte[1024];
        int res;
        long d1 = System.currentTimeMillis();
        while ((res = bis.read(resList)) != -1) {
            bos.write(resList,0,resList.length);
            // System.out.println(Arrays.toString(resList));
        }
        long d2 = System.currentTimeMillis();
        System.out.println(d2-d1);
    }
}
