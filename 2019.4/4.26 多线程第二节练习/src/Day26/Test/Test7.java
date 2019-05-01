package Day26.Test;
//线程优先级相关操作；

class MyThread7 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 5;i++){
            System.out.println("当前线程"+
                    Thread.currentThread().getName()+", i = "+i);
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        MyThread7 myThread7 = new MyThread7();
        Thread t1 = new Thread(myThread7,"t1");
        Thread t2 = new Thread(myThread7,"t2");
        Thread t3 = new Thread(myThread7,"t3");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("当前main线程优先级别为："
                +Thread.currentThread().getPriority());

    }
}
