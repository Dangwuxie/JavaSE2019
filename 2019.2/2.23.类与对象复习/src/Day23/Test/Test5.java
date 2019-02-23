package Day23.Test;

class Person5{
    private String name;
    private int age;
    public Person5(String name, int age) {
        name = name;
        age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Person5 person5 = new Person5("张三",666);
        System.out.println(person5.getAge());
        System.out.println(person5.getName());
    }
}
