package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 *    boolean isHeldByCurrentThread():
 *    查询当前线程是否保持此锁定；
 */


class Service15{
    private ReentrantLock lock;

    public Service15(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try{
            System.out.println(lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println(lock.isHeldByCurrentThread());
        }finally {
            lock.unlock();
        }
    }
}
public class Test15 {
    public static void main(String[] args) {
        final Service15 service15 = new Service15(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service15.serviceMethod();
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