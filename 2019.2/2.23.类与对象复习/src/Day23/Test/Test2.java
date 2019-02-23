package Day23.Test;

class Person2{
    String name;
    int age;
}
public class Test2 {
    public static void main(String[] args) {
        Person2 per2 = new Person2();
        Person2 per3 = per2 ;
        System.out.println(per3.age);
    }
}
