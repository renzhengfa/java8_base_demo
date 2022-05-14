package com.knrentestbase001.interface1;

public class Zi extends Fu implements Animal {

    @Override
    public String eat() {
        return "子重写覆盖eat方法";
    }

    @Override
    public String sleep() {
        return "子重写覆盖sleep方法";
    }

}
