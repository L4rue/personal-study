package lagou.task21.template;

public abstract class AbstractCalculator {
    // 自定义成员方法实现  将参数指定的表达式exp 按照  参数指定的规则regex 进行切割并执行指定方法
    public int splitExpression(String exp, String regex) {
        String[] arr = exp.split(regex);
        return calculate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }

    // 自定义抽象方法实现运算
    public abstract int calculate(int a, int b);
}
