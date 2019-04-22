package Day20.Test;
//重复元素判断
//hashCode与equals方法；
//对照课件敲；

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person7 implements Comparable<Person7>{
    private String name;
    private Integer age;

    public Person7(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{ name= "+ name +"  age = "+ age+" }";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person7 person7 = (Person7) obj;
        return Objects.equals(this.name,person7.name) &&
                Objects.equals(this.age,person7.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    //@Override
    public int compareTo(Person7 o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age < o.age){
            return -1;
        }else {
            return this.name.compareTo(o.name);
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        Set<Person7> set = new HashSet<>();
        /*set.add(new Person7("张三",20));
        //重复元素
        set.add(new Person7("张三",20));
        set.add(new Person7("李四",30));
        set.add(new Person7("王五",40));*/
        //System.out.println(set);
        System.out.println(new Person7("张三",20).compareTo(new Person7("张三",11)));

    }
}
