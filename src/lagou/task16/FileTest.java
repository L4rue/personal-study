package lagou.task16;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File f1 = new File("src/Main.java");
        if(f1.exists()) {
            System.out.println("name: " + f1.getName());
            System.out.println("length: " + f1.length());

            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(f1.lastModified());
            System.out.println("最后一次修改时间： " + instance.getTime());
            Date d1 = new Date(f1.lastModified());
            System.out.println("绝对路径： " + f1.getAbsolutePath());
        } else {
            f1.createNewFile();
        }

        // 遍历目录


    }

    void forFile(String path) {
        File f2 = new File(path);
        if(f2.exists()) {
            File[] fileList = f2.listFiles();
            for (File file :fileList)  {
            }
        }
    }
}
