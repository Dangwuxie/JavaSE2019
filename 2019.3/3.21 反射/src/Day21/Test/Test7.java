package Day21.Test;

import java.lang.reflect.Constructor;
class Person7{
    private String name;
    private Integer age;
    public Person7(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name+"  "+age;
    }
}
public class Test7 {
    public static void main(String[] args) throws Exception {
        Class<Person7> cls = Person7.class;
        Constructor constructor =
                cls.getDeclaredConstructor(String.class,Integer.class);
        //constructor.setAccessible(true);
        Person7 person7 = (Person7) constructor.newInstance("asca",18);
        System.out.println(person7);
    }
}
