package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  *    boolean isLocked()的作用是查询此锁定是否由任意线程保持；
 */

class Service16{
    private ReentrantLock lock;

    public Service16(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try{
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
        }finally {
            lock.unlock();
        }
    }
}
public class Test16 {
    public static void main(String[] args) {
        final Service16 service16 = new Service16(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service16.serviceMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.start();
    }
}

/*
运行结果：

    false
    true
 */