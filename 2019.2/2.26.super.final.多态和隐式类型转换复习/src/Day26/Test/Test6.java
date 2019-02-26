package Day26.Test;

class Person6{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Student6{
    private int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
public class Test6 {
    public static void main(String[] args) {
     final Person6 person6;
     person6 = new Person6();
     person6.setName("张三");
     System.out.println(person6.getName());
    }
}
