package Day20.Test;

class Dog1{
    private String name;
    private int age;
    public Dog1(){
        System.out.println("**********************");
    }
    public Dog1(String name){
        this();
        this.name = name;
    }
    public Dog1(String name,int age){
        this(name);
        this.age = age;
    }
    public void printInFo(){
        System.out.println("年龄："+this.age+"姓名："+this.name);
    }
}
public class Test4 {
    public static void main(String[] args) {
        Dog1 dog = new Dog1("小红",12);
        dog.printInFo();
    }
}
