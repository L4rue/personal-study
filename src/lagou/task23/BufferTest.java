package lagou.task23;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 缓冲区
 */
public class BufferTest {
    public static void main(String[] args) {
        // 每个基本数据类型都有对应的缓冲区，byte -> byteBuffer, int -> intBuffer 等
        // 1. 创建缓冲区
        // a.第一种创建方式，在堆中创建缓冲区：allocate(int capacity)  最常使用
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        // b.第二种创建方式，在系统内存中创建缓冲区：allocateDirect(int capacity)
        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(10);
        // c.第三种创建方式，通过普通数组创建缓冲区：wrap(byte[] arr)
        byte[] bytes = new byte[10];
        ByteBuffer byteBuffer3 = ByteBuffer.wrap(bytes);

        // 2. 缓冲区的操作
        printBuffer(byteBuffer1);

        // put(byte b): 向数组添加内容
        byteBuffer1.put((byte) 97);
        byteBuffer1.put((byte) 98);
        byteBuffer1.put((byte) 99);
        byteBuffer1.put((byte) 'a');
        printBuffer(byteBuffer1);

        // get(): 获取从position起第一个元素,会导致position向后移动一位
        byte b = byteBuffer1.get();
        System.out.println(b);

        System.out.println("-------------");
        /*
          Buffer抽象类的四个核心属性

          capacity: 缓冲区的最大容量，一经设定，不可改变
          position: 下一个读/写的位置
          limit: 缓冲区中可以操作的数据大小
          mark: 备忘位置，用于标记当前的读写位置（position值）
         */
        // capacity
        System.out.println("capacity：" + byteBuffer1.capacity()); // 10
        // position
        System.out.println("position: " + byteBuffer1.position()); // 5
        byteBuffer1.put((byte) 100);
        System.out.println("position: " + byteBuffer1.position()); // 6
        // limit
        System.out.println("limit: " + byteBuffer1.limit()); // 10

        System.out.println("-------------");
        // flip() :  position -> limit , 0 -> position
        // 一般将flip称为 切换成“读模式” ⭐️
        byteBuffer1.flip();
        System.out.println("capacity：" + byteBuffer1.capacity()); // 10
        System.out.println("position: " + byteBuffer1.position()); // 0
        System.out.println("limit: " + byteBuffer1.limit()); // 6

        // 创建limit大小的字节数组
        byte[] dst = new byte[byteBuffer1.limit()];
        // 将读取出来的数据装进字节数组中
        byteBuffer1.get(dst);
        System.out.println(Arrays.toString(dst));
        System.out.println(new String(dst));

        System.out.println("-------------");
        // clear()  清空缓冲区，回归“写模式”，重置核心属性值
        byteBuffer1.clear();
        System.out.println("capacity：" + byteBuffer1.capacity()); // 10
        System.out.println("position: " + byteBuffer1.position()); // 0
        System.out.println("limit: " + byteBuffer1.limit()); // 10
        System.out.println((char) byteBuffer1.get()); // 之前存的数据仍然存在，只是标记为不存在

        System.out.println("-------------");
        // mark属性 验证
        byteBuffer1.put((byte) 101);
        System.out.println("position: " + byteBuffer1.position()); // 2
        // 标记当前position位置
        System.out.println("mark: " + byteBuffer1.mark()); // java.nio.HeapByteBuffer[pos=2 lim=10 cap=10]

        byteBuffer1.put((byte) 101);
        System.out.println("position: " + byteBuffer1.position()); // 3
        byteBuffer1.reset(); // 将position还原到标记的位置
        System.out.println("position: " + byteBuffer1.position()); // 2
    }

    public static void printBuffer(ByteBuffer buffer) {
        // 把缓冲区数组变成普通数组 查看数组内容
        byte[] array = buffer.array();
        System.out.println(Arrays.toString(array));
    }

    public static void printBufferString(ByteBuffer buffer) {
        System.out.println(new String(buffer.array()));
    }
}
