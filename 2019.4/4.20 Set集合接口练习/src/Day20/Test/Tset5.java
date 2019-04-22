package Day20.Test;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


class Person5 implements Comparator<Person5>{
    private Integer age;
    private String name;

    public Person5(String name,Integer age) {
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
    public String toString() {
        return "{ name= "+ name +"  age = "+ age+" }";
    }

    @Override
    public int compare(Person5 o1, Person5 o2) {
        return 0;
    }
}
class AscAgeComparator implements Comparator<Person5>{
    @Override
    public int compare(Person5 o1, Person5 o2) {
        return o1.getAge() - o2.getAge();
    }
}

class DascAgeComparator implements Comparator<Person5>{
    @Override
    public int compare(Person5 o1, Person5 o2) {
        return o2.getAge() - o1.getAge();
    }
}
public class Tset5 {
    public static void main(String[] args) {
        /*Set<Person5> set = new TreeSet<>(new AscAgeComparator());
        set.add(new Person5("张三",20));
        set.add(new Person5("李四",30));
        System.out.println(set);*/
        //Set<Person5> set1 = new HashSet<>(new AscAgeComparator());
        /*set1.add(new Person5("张三",33));
        set1.add(new Person5("李四",44));
        System.out.println(set1);*/
    }
}
