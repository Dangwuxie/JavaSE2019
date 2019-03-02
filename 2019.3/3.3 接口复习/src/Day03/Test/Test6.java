package Day03.Test;
//定义一个内部静态类
interface A6{
    void print6();
    static interface B6{
        void fun6();
    }
}
class Impl6 implements A6,A6.B6{
    @Override
    public void print6() {
        System.out.println("print6");
    }
    @Override
    public void fun6() {
        System.out.println("fun6");
    }
}
public class Test6 {
    public static void main(String[] args) {
        A6 a6 = new Impl6();
        ((Impl6) a6).fun6();
        a6.print6();
    }
}
