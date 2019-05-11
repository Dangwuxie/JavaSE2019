package Day05.Test;
//留意：i--与System.out.println的异常

class MyThread1 implements Runnable{
    private int i = 5;

    @Override
    public synchronized void run() {
        System.out.println("i="+(i--)+"ThreadName="
                +Thread.currentThread().getName());
    }
}
public class Test1 {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread1);
        Thread t3 = new Thread(myThread1);
        Thread t4 = new Thread(myThread1);
        Thread t5 = new Thread(myThread1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
