package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test8
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 7、懒汉模式的解决方案5：使用静态内置类实现单例模式：
 * @date 2019/6/7 10:43
 */

class MyObject8{
    //内部类方法式
    private static class MyObject8Handler{
        private static MyObject8 myObject8 = new MyObject8();
    }

    public MyObject8() {
    }
    public static MyObject8 getInstance(){
        return MyObject8Handler.myObject8;
    }
}
class Thread8 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject8.getInstance().hashCode());
    }
}
public class Test8 {
    public static void main(String[] args) {
        Thread8 t1 = new Thread8();
        Thread8 t2 = new Thread8();
        Thread8 t3 = new Thread8();
        t1.start();
        t2.start();
        t3.start();
    }
}
/*
运行结果：

    661713944
    661713944
    661713944
 */