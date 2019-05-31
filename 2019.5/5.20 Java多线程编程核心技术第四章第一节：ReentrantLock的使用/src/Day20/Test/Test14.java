package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * boolean isFair()：判断是不是公平锁；
 */
class Service14{
    private ReentrantLock lock;

    public Service14(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try{
            lock.lock();
            System.out.println("是不是公平锁："+lock.isFair());
        }finally {
            lock.unlock();
        }
    }
}
public class Test14 {
    public static void main(String[] args) {
        final Service14 service14a = new Service14(true);
        final Service14 service14b = new Service14(false);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                service14a.serviceMethod();
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                service14b.serviceMethod();
            }
        };
        Thread threadA = new Thread(runnable1);
        Thread threadB = new Thread(runnable2);
        threadA.start();
        threadB.start();
    }
}
/*
    运行结果：

    是不是公平锁：true
    是不是公平锁：false
 */