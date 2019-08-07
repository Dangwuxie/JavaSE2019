package Sreializeable;

import java.io.Serializable;

/**
 * @author Dangxuchao
 * @Title: Person
 * @ProjectName IO复习
 * @Description: 序列化
 * @date 2019/8/7 11:06
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
