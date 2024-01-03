package lagou.old;

import javax.lang.model.type.ArrayType;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class regTest {
    public static void main(String[] args) {
        String test = "11389702684";
        String reg = "([1-9]\\d{2})\\d{4}(\\d{4})";
        Pattern p = Pattern.compile(reg);
        System.out.println(test.replaceAll(reg,"$1****$2"));

//        StringBuilder s1 = new StringBuilder();
//        s1.append("123");
//        String test1 = new Scanner(System.in).next();
//        String test2 =Optional.ofNullable(test1).orElse("123");

        LocalDateTime ldt = LocalDateTime.of(2008,8,9,12,0,0);
        ldt = ldt.withYear(2009);
        ldt = ldt.plusDays(2);

        System.out.println(ldt);
//        System.out.println(ldt2);
//        System.out.println(ldt3);









    }

}
