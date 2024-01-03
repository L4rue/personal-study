package lagou.task22;

import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {
    public static void main(String[] args) {
        // Java 中使用Optional类实现空值处理
        // 1. 将数据str1装入Optional容器
        String str1 = null;
        Optional<String> optional = Optional.ofNullable(str1);
        // 2. 建立映射关系  使用字符串长度与字符串建立映射关系
        Optional<Integer> integer = optional.map(new Function<>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        // 3.若字符串为空值则打印0，否则打印字符串的数值
        System.out.println(integer);
        System.out.println(integer.orElse(0));
    }
}
