package com.knrentestbase001.extends1;

/*
继承特点：
抽取共性，子类可以拥有父类的内容，子类也可以拥有自己专有的内容。
父类又叫基类，超类；子类又叫派生类。

子类自己有的用自己的，如果子类没有就会向父类中查找。

重写（@Override）：在类的继承中，
1、子类方法名称和参数都要完全一致，
2、以及返回值类型要【小于等于】父类的方法返回值，
3、子类的方法修饰符权限一定要大于等于父类的方法权限修饰符。
public > protected > (default) > private（default不是关键字default，而是什么都不写）

子类构造方法内默认有一个supper();当父类没有无参构造时，子类构造方法会报错（父类没有空参构造，可以采用有参构造）
supper（）只有一个且必须为子类构造方法内的第一行。

只能单继承，因为当多继承时，两个父类都有一个方法method（），当子类没有这个方法时，子类到底该用哪一个父类的这个方法。
 */
public class Extends1 {

    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        teacher.method();
        Assistant assistant = new Assistant();
        assistant.method();
        System.out.println(teacher.name);
    }

}
