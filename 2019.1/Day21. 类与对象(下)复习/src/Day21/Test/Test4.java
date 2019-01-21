package Day21.Test;

public class Test4 {
    public Test4(){
        System.out.println("1.主类中的构造方法");
    }
    {
        System.out.println("2.主类中的构造块");
    }
    static {
        System.out.println("3.主类中的静态代码块");
    }
    public static void main(String[] args) {
        System.out.println("4.开始实例化对象");
        new Test4();
        new Test4();
        System.out.println("5.结束");
    }
}
