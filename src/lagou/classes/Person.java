package lagou.classes;

public class Person<T>{
    private String name;
    private Integer age;
    private T generic;

    public Person() {
    }

    public Person(String name, Integer age, T generic) {
        this.name = name;
        this.age = age;
        this.generic = generic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 不是范型方法
    // 不能使用static修饰，因为该方法中的T需要new对象时才能确定
    public /*static*/ T getGeneric() {
        return generic;
    }

    public void setGeneric(T generic) {
        this.generic = generic;
    }

    // 自定义成员方法实现参数指定数组中的所有元素打印出来
    // 范型方法
    public static <T1> void  printArray(T1[] arr) {
        for (T1 tt:arr) {
            System.out.println(tt);
        }
    }
}
