package lagou.task21.template;

public class AbstractCalculatorTest {
    public static void main(String[] args) {
        AbstractCalculator abstractCalculator = new Plus();
        int value = abstractCalculator.splitExpression("1+1", "\\+");
        System.out.println(value);

        AbstractCalculator abstractCalculator2 = new Minus();
        int value2 = abstractCalculator2.splitExpression("1-1", "\\-");
        System.out.println(value2);
    }
}
