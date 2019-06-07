package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test10
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 9、懒汉模式的解决方案6：使用static代码块实现单例模式；
 * @date 2019/6/7 11:19
 */

class MyObject10{
    private static MyObject10 instance = null;

    public MyObject10() {
    }
    static{
        instance = new MyObject10();
    }
    public static MyObject10 getInstance(){
        return instance;
    }
}
class Thread10 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 3;i++){
            System.out.println(
                    MyObject10.getInstance().hashCode()+" "+(i+1));
        }
    }
}
public class Test10 {
    public static void main(String[] args) {
        Thread10 t1 = new Thread10();
        Thread10 t2 = new Thread10();
        Thread10 t3 = new Thread10();
        t1.start();
        t2.start();
        t3.start();
    }
}
