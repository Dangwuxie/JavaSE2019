package Day20.Test;

class Person{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
public class Test1 {
    public static void main(String[] args) {
        Person per = new Person();
        per.setAge(22);
        per.setName("张三");
        System.out.println(per.getName());
        System.out.println(per.getAge());
    }
}
