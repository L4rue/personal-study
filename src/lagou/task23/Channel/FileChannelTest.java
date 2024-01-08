package lagou.task23.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void method() throws IOException {
        // 1.创建输入流输出流（依赖IO流获取Channel）
        FileInputStream fileInputStream = new FileInputStream("src/lagou/task23/Channel/99_source.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/lagou/task23/Channel/99_copyFile.txt");

        // RandomAccessFile accessFile = new RandomAccessFile("src/lagou/task23/Channel/99_source.txt", "rw");
        // FileChannel fileChannel = accessFile.getChannel();

        // 2.通过IO流获取Channel通道
        FileChannel fileChannel1 = fileInputStream.getChannel(); // 只能读
        FileChannel fileChannel2 = fileOutputStream.getChannel(); // 只能写

        // 3.创建缓冲区
        ByteBuffer bf = ByteBuffer.allocate(1024);

        // 4. 循环读写
        while (fileChannel1.read(bf) != -1) {
            // 切换到读模式，重置position位置，因为上面的读取操作向缓冲区中写入数据，改变了position，
            // 下面写入要读取缓冲区时，position位置不对，
            // 因此执行flip(), 更新limit位置到当前position位置，并将position放到初始位置，
            // 即标记字节的开始（position）与结束位置（limit）
            bf.flip();
            fileChannel2.write(bf);
            // 重置position和limit位置，以保证下一次缓冲区的写入
            bf.clear();
        }

        // 5.关闭通道
        fileChannel1.close();
        fileChannel2.close();
    }
}
