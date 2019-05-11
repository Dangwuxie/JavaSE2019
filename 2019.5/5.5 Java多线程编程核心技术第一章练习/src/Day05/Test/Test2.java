package Day05.Test;
//区别当前代码是被哪个线程所调用；
class MyThread2 implements Runnable{
    public MyThread2() {
        System.out.println("构造方法:"+Thread.currentThread().getName());
    }

    @Override
    public void run() {

        System.out.println("run方法:"+Thread.currentThread().getName());
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2,"子线程");
        t1.start();
    }
}
