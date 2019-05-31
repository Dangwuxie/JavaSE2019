package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * boolean tryLock()：
 * 仅在调用时锁定未被另外一个线程保持的情况下，才获取该锁定；
 */
class Service18{
    private ReentrantLock lock = new ReentrantLock();
    public void waitMethod(){
        if (lock.tryLock()){
            System.out.println(Thread.currentThread().getName()+"获得了锁");
        }else {
            System.out.println(Thread.currentThread().getName()+"没有获得锁");
        }
    }
}
public class Test18 {
    public static void main(String[] args) {
        final Service18 service18 = new Service18();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service18.waitMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
    }
}
/*
    运行结果：

    A获得了锁
    B没有获得锁
 */