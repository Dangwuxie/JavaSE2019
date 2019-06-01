package Day25.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写写互斥；
 * 写锁与写锁之间互斥，同一时间只允许一个Thread进行写入操作；
 */

class Service2{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void write(){
        try{
            lock.writeLock().lock();
            System.out.println("获得写锁："+Thread.currentThread().getName()
                    +" "+System.currentTimeMillis());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
class Thread2A extends Thread{
    private Service2 service2;

    public Thread2A(Service2 service2) {
        this.service2 = service2;
    }

    @Override
    public void run() {
        service2.write();
    }
}
class Thread2B extends Thread{
    private Service2 service2;

    public Thread2B(Service2 service2) {
        this.service2 = service2;
    }

    @Override
    public void run() {
        service2.write();
    }
}
public class Test2 {
    public static void main(String[] args) {
        Service2 service2 = new Service2();
        Thread2A thread2A = new Thread2A(service2);
        thread2A.setName("2A");
        Thread2B thread2B = new Thread2B(service2);
        thread2B.setName("2B");
        thread2A.start();
        thread2B.start();
    }
}
/*
    运行结果：
    获得读锁：2A 1559366033701
    获得读锁：2B 1559366036701
    由运行结果可以看出，lock.writeLock()同一时间只允许一个线程执行lock()后面的方法;
 */
