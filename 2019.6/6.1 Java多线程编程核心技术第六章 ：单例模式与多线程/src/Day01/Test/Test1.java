package Day01.Test;

/**
 * 立即加载/饿汉模式
 */

class MyObject1{
    private static MyObject1 myObject1 = new MyObject1();
    private MyObject1(){

    }
    public static MyObject1 getInstannce(){
        return myObject1;
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject1.getInstannce().hashCode());
    }
}
public class Test1 {

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
    }
}
/*
运行结果：
    676905244
    676905244
    676905244

 */