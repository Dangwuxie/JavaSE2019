package Day25.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写互斥；
 * 写读操作
 */

class Service3{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read(){
        try{
            lock.readLock().lock();
            System.out.println("获得读锁线程："+Thread.currentThread().getName()
                    +" "+System.currentTimeMillis());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
    public void write(){
        try{
            lock.writeLock().lock();
            System.out.println("获得写锁线程："+Thread.currentThread().getName()
                    +" "+System.currentTimeMillis());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}
class Thread3A extends Thread{
    private Service3 service3;

    public Thread3A(Service3 service3) {
        this.service3 = service3;
    }

    @Override
    public void run() {
        service3.read();
    }
}
class Thread3B extends Thread{
    private Service3 service3;

    public Thread3B(Service3 service3) {
        this.service3 = service3;
    }

    @Override
    public void run() {
        service3.write();
    }
}
public class Test3 {
    public static void main(String[] args) {
        Service3 service3 = new Service3();

        Thread3B thread3B = new Thread3B(service3);
        thread3B.setName("B");
        thread3B.start();

        Thread3A thread3A = new Thread3A(service3);
        thread3A.setName("A");
        thread3A.start();

        System.out.println("主线程结束时间："+System.currentTimeMillis());
    }
}
/*
    运行结果：

        主线程结束时间：1559366890979
        获得读锁线程：A 1559366890980
        获得写锁线程：B 1559366893981
 */