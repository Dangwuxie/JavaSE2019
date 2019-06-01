package Day25.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类ReentrantReadWriteLock的使用：读读共享
 *  读锁之间不互斥
 */

class Service1{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read(){
        try{
            lock.readLock().lock();
            System.out.println("获得读锁："+Thread.currentThread().getName()
                    +" "+System.currentTimeMillis());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
}
class ThreadA extends Thread{
    private Service1 service1;

    public ThreadA(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public void run() {
        service1.read();
    }
}
class ThreadB extends Thread{
    private Service1 service1;

    public ThreadB(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public void run() {
        service1.read();
    }
}
public class Test1 {

    public static void main(String[] args) {
        Service1 service1 = new Service1();
        ThreadA threadA = new ThreadA(service1);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(service1);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
/*
    运行结果：

    获得读锁：A 1559365518307
    获得读锁：B 1559365518309

    从运行结果可以看出，两个线程几乎同时执行lock()方法后面的代码；
 */