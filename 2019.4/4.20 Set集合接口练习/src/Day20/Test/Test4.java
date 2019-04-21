package Day20.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
//观察实现Comparable接口的类的compareTo方法的三种返回值；

class Person4 implements Comparable<Person4>{
    private Integer age;
    private String name;

    public Person4(String name,Integer age) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person4 o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age == o.age){
            return 0;
        }else if (this.age < o.age){
            return -1;
        }else {
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "{ name= "+ name +"  age = "+ age+" }";
    }
}

public class Test4 {
    public static void main(String[] args) {
        Set<Person4> set = new TreeSet<>();
        set.add(new Person4("张三",20));
        set.add(new Person4("李四",30));
        System.out.println(new Person4("李四",40).compareTo(new Person4("李四",38)));
        System.out.println(new Person4("李四",40).compareTo(new Person4("李四",40)));
        System.out.println(new Person4("李四",40).compareTo(new Person4("李四",44)));
        System.out.println(set);
    }
}
