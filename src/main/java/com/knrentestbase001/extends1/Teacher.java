package com.knrentestbase001.extends1;

import java.util.ArrayList;

//子类
public class Teacher extends Employee {

    @Override
    public String overRideFu(String a) {
        ArrayList<String> arrayList = new ArrayList<String>();
        return super.overRideFu(a);

    }


}
