package Day01.Test;
//通过程序自己加锁；
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class MyThread7 implements Runnable{
    private int ticket = 20;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (this.ticket > 0){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                if (this.ticket > 0){
                    System.out.println(Thread.currentThread().getName()
                            +"买票  剩余"+--this.ticket+"张");
                    if (this.ticket == 0){
                        System.out.println("票卖完了。。。");
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

public class Test7 {
    public static void main(String[] args) {
        Runnable myThread2 = new MyThread7();
        Thread thread1 = new Thread(myThread2,"黄牛A");
        Thread thread2 = new Thread(myThread2,"黄牛B");
        Thread thread3 = new Thread(myThread2,"黄牛C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
