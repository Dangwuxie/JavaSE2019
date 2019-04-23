package Day21.Test;
//自定义类使用Map集合；

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Person{
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
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
        return this.name+"+"+this.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age,name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(this.age,person.age) &&
                Objects.equals(this.name,person.name);
    }
}
public class Test4 {
    public static void main(String[] args) {
        Map<Person,String> map = new HashMap<>();
        map.put(new Person(20,"张三"),"一班");
        System.out.println(map.get(new Person(20,"张三")));
    }
}
