package com.knrentestbase001.duotai;

/*
多态体现：（父类引用指向子类对象）
例：父类or接口 obj = new 子类or接口实现类();
当父类和子类都有相同方法时，看new的那个就会调用那个对象的成员方法。
 */
public class Duotai1 {

    public static void main(String[] args) {

        Human human = new Student();
        human.method();//Student method！！！
        //当子类没有该方法时会去调用父类的方法
        human.methodFu();//Human methodFu!!!
        int a = human.a;
        System.out.println(a);//11

        Student student = new Student();
        System.out.println(student.a);//10
        //对象名点成员变量：看等号左边是谁，优先使用谁，没有则向上找。

        System.out.println((int)10.1);//10
    }

    /*
    instaceof
     */
    public static boolean instanceOfCast(Human human){
        Human human_teacher = new Teacher();
        Human human_student = new Student();
        if (human_student instanceof Student) {
            Student student = (Student)human_student;
        }
        if (human_teacher instanceof Teacher) {
            Teacher teacher = (Teacher) human_teacher;
        }
        return true;
    }

}
