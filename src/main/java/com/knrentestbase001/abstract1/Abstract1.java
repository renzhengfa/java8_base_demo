package com.knrentestbase001.abstract1;

/*
有抽象方法的类必须为抽象类，抽象类可以没有抽象方法。
抽象类为类前面加上abstract，抽象方法加abstract，抽象方法没有方法体。
抽象类的子类必须实现所有父类抽象方法。

不能直接创建抽象对象（使用创建子类对象）。
覆盖重写（实现）：子类去掉abstract关键字，补全方法体大括号里面的内容。
 */
public abstract class Abstract1 {

    public abstract String getStr();

    private String getString(){
        return "";
    }

}
