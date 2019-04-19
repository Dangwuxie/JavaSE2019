package Day15.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person2{
    private String name;
    private Integer age;

    public Person2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if (obj == this){
            return true;
        }
        //非空性
        else if (obj == null){
            return false;
        }
        //
        else if (!(obj instanceof Person2)){
            return false;
        }
        Person2 per2 = (Person2) obj;
        return per2.age.equals(this.age) &&
                per2.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "{Name = "+name+"; Age = "+age+"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(age,name);
    }
}
public class Test2 {
    public static void main(String[] args) {
        Person2 per1 = new Person2("张三",22);
        Person2 per2 = new Person2("张三",22);
        System.out.println(per1.equals(per2));
        Set<Person2> set = new HashSet<>();
        set.add(new Person2("张三",22));
        set.add(new Person2("李四",66));
        set.add(new Person2("张三",22));
        System.out.println(set);
    }
}
