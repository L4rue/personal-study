package lagou;

public class IntegerTest {
    public static void main(String[] args) {
//        Double left = Double.NaN;
//        left.isNaN();

        Boolean f1 = Boolean.valueOf("true");
        Boolean f2 = Boolean.valueOf("truE");
        Boolean f3 = Boolean.valueOf("123");
        Boolean f4 = Boolean.parseBoolean("true");
        Boolean f5 = Boolean.parseBoolean("truE");
        Boolean f6 = Boolean.parseBoolean("123");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(f6);

        Character ca1 = 'a';
        ca1.toString();
        Character.toUpperCase(123);

        String s1 = "1,9,10";
        String s2 = "1,10,9";
        int b1 = s1.compareTo(s2);
    }
}
