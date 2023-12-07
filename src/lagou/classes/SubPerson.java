package lagou.classes;

public  class SubPerson{
    public static class SubPerson1 extends Person { // 不保留范型并且没有指定类型，则T默认为Object类型   称之为擦除

    }
    public static class SubPerson2<Boolean> extends Person<Boolean> { // 不保留范型并指定范型，则T为指定的类型

    }
    public static class SubPerson3<T> extends Person<T> { // 保留范型写法

    }
    public static class SubPerson4<T,T2> extends Person<T> { // 保留父类范型写法并且追加新的范型

    }
}


