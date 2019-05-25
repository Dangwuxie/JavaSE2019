package Day18.Test;

/**
 * 验证线程变量的隔离性；
 */
class Tools{
    public static ThreadLocal t1 = new ThreadLocal();
}
//自定义两个线程类代码

class Thread2A extends Thread{
    @Override
    public void run() {
        try{

            for (int i = 0;i < 5;i++){
                Tools.t1.set("线程A"+(i+1));
                System.out.println("A线程获取值："+Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Thread2B extends Thread{
    @Override
    public void run() {
        try{
            for (int i = 0;i < 5;i++){
                Tools.t1.set("线程B"+(i+1));
                System.out.println("B线程获取值："+Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        try{
            Thread2A a2 = new Thread2A();
            Thread2B b2 = new Thread2B();
            a2.start();
            b2.start();
            for (int i = 0;i < 5;i++){
                Tools.t1.set("Main线程"+(i+1));
                System.out.println("Main线程获取值："+Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    运行结果：

    Main线程获取值：Main线程1
    A线程获取值：线程A1
    B线程获取值：线程B1
    A线程获取值：线程A2
    Main线程获取值：Main线程2
    B线程获取值：线程B2
    B线程获取值：线程B3
    Main线程获取值：Main线程3
    A线程获取值：线程A3
    B线程获取值：线程B4
    Main线程获取值：Main线程4
    A线程获取值：线程A4
    B线程获取值：线程B5
    Main线程获取值：Main线程5
    A线程获取值：线程A5

    由结果可以看出：三个线程都往同一个ThreadLocal对象里面存值，
    但是都能取出自己的数据；
 */