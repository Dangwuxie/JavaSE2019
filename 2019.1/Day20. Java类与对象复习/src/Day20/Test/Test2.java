package Day20.Test;

class Person2{
    private String name = "dog";
    private int age;
    public Person2(int ag,String na){
        age = ag;
        name = na;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
public class Test2 {
    public static void main(String[] args) {
        Person2 person= new Person2(22,"张三");
        System.out.println("年龄："+person.getAge()+"姓名："+person.getName());
    }
}
