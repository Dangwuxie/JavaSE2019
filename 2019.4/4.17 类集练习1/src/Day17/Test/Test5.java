package Day17.Test;
//集合与简单Java类

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{ name = "+name+","+"age = "+age+"}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return Objects.equals(name,person.name) &&
                Objects.equals(age,person.age);
    }
}

public class Test5 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三",10));
        personList.add(new Person("李四",20));
        personList.add(new Person("王五",30));

        personList.add(new Person("张三",10));
        //集合类中contains()/remove方法需要equals()支持；
        System.out.println(personList.contains(new Person("王五",30)));
        for (Person o : personList){
            System.out.print(o+"  ");
        }
    }
}
