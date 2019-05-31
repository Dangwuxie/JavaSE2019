package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * boolean hasWaiters(Condition condition):
 *  查询是否有线程正在等待与锁定有关的condition条件；
 */

class Service13{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void wait13(){
        try{
            lock.lock();
            condition.await();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void notify13(){
        try{
            lock.lock();
            System.out.println("是否有线程正在等待newCondition？"+lock.hasWaiters(condition));
            System.out.println("线程数是多少？"+lock.getWaitQueueLength(condition));
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
public class Test13 {
    public static void main(String[] args) throws InterruptedException {
        final Service13 service13 = new Service13();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service13.wait13();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0;i < 10;i++){
            threads[i] = new Thread(runnable);
        }
        for (int i = 0;i < 10;i++){
            threads[i].start();
        }
        Thread.sleep(1000);
        service13.notify13();
    }
}
/*
    运行结果：

    是否有线程正在等待newCondition？true
    线程数是多少？10
 */