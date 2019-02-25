package Day23.Test;
//静态代码块；使用static定义的代码块；
//非主类中的静态代码块；
class Person3{
    {
        System.out.println("Person类的构造块");
    }
    public Person3(){
        System.out.println("Person中的构造方法");
    }
    static{
        System.out.println("非主类中的静态代码块");
    }
}
public class Test3 {
    public static void main(String[] args) {
        new Person3();
        System.out.println("第二次实例化..........");
        new Person3();
    }
}
