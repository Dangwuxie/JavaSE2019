package Day13.Test;

import java.util.Set;
import java.util.TreeSet;

class Person4 implements Comparable<Person4>{
    private String name;
    private Integer age;

    public Person4(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "Person{"+"name="+name+","
                +"age="+age+"}";
    }

    /**
     * 自定义Person类如何比较大小
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person4 o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age < o.age){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }
    }
}
public class Test4 {
    public static void main(String[] args) {

        Set<Person4> set = new TreeSet<>();
        set.add(new Person4("六号",666));
        set.add(new Person4("七号",555));

        System.out.println(set);
    }
}
