package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * int getHoldCount()：
 * 查询当前线程保持此锁定的个数，也就是调用lock()方法的次数；
 * 练习练习：：：：
 */
class Service9{
    private ReentrantLock lock = new ReentrantLock();
    public void serviceMethod1(){
        try{
            lock.lock();
            System.out.println("方法一获得的保持此锁定的个数："+lock.getHoldCount());
            serviceMethod2();
        }finally {
            lock.unlock();
        }
    }
    public void serviceMethod2(){
        try{
            lock.lock();
            System.out.println("方法二保持此锁定的个数："+lock.getHoldCount());
        }finally {
            lock.unlock();
        }
    }
}
public class Test9 {
    public static void main(String[] args) {
        Service9 service9 = new Service9();
        service9.serviceMethod1();
    }
}
/*
    运行结果：

    方法一获得的保持此锁定的个数：1
    方法二保持此锁定的个数：2

 */