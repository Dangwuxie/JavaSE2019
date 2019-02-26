package Day26.Test;

class Person4{
    private String name;
    private int age;
    public Person4(String name){
        this.name = name;
        System.out.println("张三");
    }
    public Person4(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("李四");
    }
}
class Student4 extends Person4{
    public Student4(){
        super("张三");
        System.out.println("子类的构造方法");
    }
}
public class Test4 {
    public static void main(String[] args) {
        new Student4();
    }
}
