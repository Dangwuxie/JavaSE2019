package Day23.Test;

class Person4{
    private String name;
    private int age;
    public Person4(int age){
        this.age = age;
    }
    public Person4(int age,String name){
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
public class Test4 {
    public static void main(String[] args) {
        Person4 person4 = new Person4(666);
        Person4 person41 = new Person4(333,"阿三");
        System.out.println(person4.getAge());
        System.out.println(person41.getAge());
        System.out.println(person41.getName());
    }
}
