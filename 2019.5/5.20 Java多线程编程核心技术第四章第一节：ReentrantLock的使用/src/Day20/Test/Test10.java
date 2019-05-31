package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * int getQueueLength()：
 * 返回正在等待获取此锁定的线程估计数，
 * 比如说5个线程，1个线程首先执行了wait()方法，
 * 那么调用此方法后返回4，说明有4个线程同时再等待lock的释放；
 */

class Service10{
    public ReentrantLock lock = new ReentrantLock();
    public void serviceMethod1(){
        try{
            lock.lock();
            System.out.println("线程名字为："+Thread.currentThread().getName()+"进入方法！");
            Thread.sleep(Integer.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        final Service10 service10 = new Service10();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service10.serviceMethod1();
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
        System.out.println("有线程数："+service10.lock.getQueueLength()+"在等待获取锁！");
    }
}
/*
    运行结果：

    线程名字为：Thread-0进入方法！
    有线程数：9在等待获取锁！

 */