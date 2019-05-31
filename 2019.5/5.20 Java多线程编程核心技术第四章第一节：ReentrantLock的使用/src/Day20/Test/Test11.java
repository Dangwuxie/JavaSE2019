package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * int getWaitQueueLength(Condition condition)：
 * 返回等待与此锁定相关的给定条件Condition的线程估计数，
 * 比如说有5个线程，每个线程都执行了同一个Condition对象的await()方法，
 * 则调用此方法时返回的是5；
 */

class Service11{
    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();
    public void waitMethod(){
        try{
            lock.lock();
            newCondition.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void notifyMethod(){
        try{
            lock.lock();
            System.out.println("有"+lock.getWaitQueueLength(newCondition)+"个线程正在等待newCondition");
            newCondition.signal();
        }finally {
            lock.unlock();
        }
    }
}
public class Test11 {
    public static void main(String[] args) throws InterruptedException {
        final Service11 service11 = new Service11();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service11.waitMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0;i < 10;i++){
            threads[i] = new Thread(runnable);
        }
        for (int i = 0;i < 10;i++){
            threads[i].start();
        }
        Thread.sleep(2000);
        service11.notifyMethod();
    }
}
/*
    运行结果：

    有10个线程正在等待newCondition

 */