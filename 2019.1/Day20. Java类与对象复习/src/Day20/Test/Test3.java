package Day20.Test;

class Dog{
    private String name;
    private int age;
    public Dog(String name,int age){
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
public class Test3 {
    public static void main(String[] args) {
        Dog dog = new Dog("小红",11);
        System.out.println("年龄：" +dog.getAge()+"姓名："+dog.getName());
    }
}
