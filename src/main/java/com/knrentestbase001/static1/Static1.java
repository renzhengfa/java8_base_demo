package com.knrentestbase001.static1;

import sun.applet.AppletResourceLoader;

/*&
static关键字：
当一个成员变量被static修饰时，那它将不再属于某一个对象，而是属于所在类。多个对象共享同一份数据。

【重要】静态方法不可以访问非静态变量，因为静态的随类加载而加载，在内存中【先】有静态的内容，【后】有非静态内容。
 */
public class Static1 {

    //当第一次用到本类时，静态代码块执行唯一的一次。
    static {
        System.out.println("static method");
    }

    public static void main(String[] args) {

        Person person1 = new Person(18,"curry");
        person1.setBlon("earth");
        Person person2 = new Person(20,"tompthon");

        System.out.println(person1);//Person{age=18, name='curry', blon=earth}
        System.out.println(person2);//Person{age=20, name='tompthon', blon=earth}

        Person.blon = "";
    }

}
