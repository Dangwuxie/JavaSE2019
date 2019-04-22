package Day20.Test;

import java.util.Set;
import java.util.TreeSet;

//使用TreeSet进行排列；
class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{ name = "+name+", age = "+age;
    }
    @Override
    public int compareTo(Person o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age < o.age){
            return  -1;
        }else {
            return this.name.compareTo(o.name);
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        set.add(new Person("张三",18));
        //重复元素
        set.add(new Person("张三",18));
        set.add(new Person("李四",20));
        set.add(new Person("王五",50));
        System.out.println(set);
    }
}
