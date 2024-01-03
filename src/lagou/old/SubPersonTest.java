package lagou.old;

import lagou.classes.Person;
import lagou.classes.SubPerson;

public class SubPersonTest {
    public static void main(String[] args) {
//        SubPerson.SubPerson1<String> sub1 = new SubPerson.SubPerson1<>();  // 报错
        SubPerson.SubPerson2<String> sub2 = new SubPerson.SubPerson2<>();
        SubPerson.SubPerson3<Boolean> sub3 = new SubPerson.SubPerson3<>();
        SubPerson.SubPerson4<Boolean,String> sub4 = new SubPerson.SubPerson4<>();
        Integer[] test = new Integer[]{11, 22, 33, 44, 55};
        Person.printArray(test);
    }
}
