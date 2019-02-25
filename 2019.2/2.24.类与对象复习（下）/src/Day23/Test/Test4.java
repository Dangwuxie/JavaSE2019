package Day23.Test;
//主类中的静态代码块；

public class Test4 {
    {
        System.out.println("主类的构造块");
    }
    static{
        System.out.println("主类的静态块");
    }
    public Test4(){
        System.out.println("主类的构造方法");
    }
    public static void main(String[] args) {
        System.out.println("new第二次Test4");

        new Test4();
        new Test4();
    }
}
