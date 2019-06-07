package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test7
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 延迟加载的解决方案4：
 *  使用DCL双检查锁机制来实现多线程环境中的延迟加载单例设计模式；
 * @date 2019/6/7 10:14
 */


class MyObject7 {
    private static volatile MyObject7 myObject7;

    public MyObject7() {
    }

    public static MyObject7 getInstance(){
        if (myObject7 == null){
            synchronized (MyObject7.class){
                if (myObject7 == null){
                    myObject7 = new MyObject7();
                }
            }
        }
        return myObject7;
    }
}

class Thread7 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject7.getInstance().hashCode());
    }
}
public class Test7 {
    public static void main(String[] args) {
        Thread7 t1 = new Thread7();
        Thread7 t2 = new Thread7();
        Thread7 t3 = new Thread7();
        t1.start();
        t2.start();
        t3.start();
    }
}
/*
运行结果：

    1211537232
    1211537232
    1211537232
 */