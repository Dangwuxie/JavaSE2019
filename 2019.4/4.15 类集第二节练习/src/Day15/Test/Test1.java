package Day15.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "{Name = "+name+"; Age = "+age+"}";
    }
}
//升序比较器
class AscAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
//降序比较器
class DescAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge()-o1.getAge();
    }
}
public class Test1 {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(new AscAgeComparator());
        set.add(new Person("张三",22));
        set.add(new Person("李四",66));
        set.add(new Person("张三",22));
        System.out.println(set);

    }
}
