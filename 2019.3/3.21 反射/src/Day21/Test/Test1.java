package Day21.Test;

import java.util.Date;
class Person1{
    private String name = "hello";
    private int age = 66;
}
public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException {
	// write your code here
        Date date = new Date();
        System.out.println(date);
        Class<Date> cls = (Class<Date>) date.getClass();
        System.out.println(cls);
        Person1 person1 = new Person1();
        Class<Person1> cls1 = (Class<Person1>) person1.getClass();
        System.out.println(cls1);
        System.out.println(Date.class);
        System.out.println(Person1.class);
        Class cls3 = Class.forName("java.util.Date");
        Class cls4 = Class.forName("Day21.Test.Person1");
        System.out.println(cls3);
        System.out.println(cls4);
    }
}
