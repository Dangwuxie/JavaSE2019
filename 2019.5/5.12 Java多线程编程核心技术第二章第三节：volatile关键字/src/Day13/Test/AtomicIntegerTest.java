package Day13.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *使用原子类进行i++操作，原子操作是不能分割的整体，
 * 没有其他线程能够中断或者检查正在原子操作中的变量；
 * 它可以在没有锁的情况下做到线程安全；
 */

class AddCountThread implements Runnable{
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName()+" "+count.incrementAndGet());
        }
    }
}
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AddCountThread countService = new AddCountThread();
        Thread t1 = new Thread(countService);
        t1.start();
        Thread t2 = new Thread(countService);
        t2.start();
        Thread t3 = new Thread(countService);
        t3.start();
        Thread t4 = new Thread(countService);
        t4.start();
        Thread t5 = new Thread(countService);
        t5.start();
    }
}
