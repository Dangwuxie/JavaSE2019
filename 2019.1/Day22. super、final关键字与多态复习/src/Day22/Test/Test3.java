package Day22.Test;

class Person2{
    private String name;
    private int age;
    //public Person2(){}
    public Person2(String name){
        this.name = name;
    }
    public Person2(String name,int age){
        this(name);
        this.age = age;
    }
}
class Son2 extends Person2{
    private String school;
    public Son2(){
        //隐藏语句
        super("张三");
        System.out.println("2、子类的构造方法");
    }
    public Son2(String school){
        this();
        this.school = school;
        System.out.println("zdczczcz");
    }
}
public class Test3 {
    public static void main(String[] args) {
        Son2 son2 = new Son2("zhangsna");
    }
}
