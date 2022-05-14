package com.knrentestbase001.duotai;

import java.util.Objects;

public class Teacher extends Human implements Comparable<Teacher> {

    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //排序规则
    @Override
    public int compareTo(Teacher o) {
//        return 0;//返回零代表元素都是相同的
        return this.age - o.age;//按照年龄升序排序
//        return o.age - this.age;//按照年龄降序排序
    }
}
