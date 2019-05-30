package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 观察公平锁与非公平锁；
 *
 */
class MyService8{
    private ReentrantLock lock;

    public MyService8(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }
    public void serviceMethod(){
        try{
            lock.lock();
            System.out.println("线程名字："+ Thread.currentThread().getName()+"获得锁定");
        }finally {
            lock.unlock();
        }
    }

}

public class Test8 {
    public static void main(String[] args) {
        final MyService8 myService8 = new MyService8(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"运行了");
                myService8.serviceMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10;i++){
            threads[i] = new Thread(runnable);
        }
        for (int i = 0;i < 10;i++){
            threads[i].start();
        }
    }
}
/*
    公平锁启动线程：

        线程Thread-1运行了
    线程名字：Thread-1获得锁定
    线程Thread-0运行了
    线程名字：Thread-0获得锁定
    线程Thread-2运行了
    线程名字：Thread-2获得锁定
    线程Thread-3运行了
    线程名字：Thread-3获得锁定
    线程Thread-4运行了
    线程名字：Thread-4获得锁定
    线程Thread-5运行了
    线程Thread-6运行了
    线程Thread-7运行了
    线程Thread-8运行了
    线程Thread-9运行了
    线程名字：Thread-5获得锁定
    线程名字：Thread-6获得锁定
    线程名字：Thread-7获得锁定
    线程名字：Thread-8获得锁定
    线程名字：Thread-9获得锁定
 */
/*
    非公平锁启动线程：

    线程Thread-0运行了
    线程Thread-1运行了
    线程名字：Thread-1获得锁定
    线程名字：Thread-0获得锁定
    线程Thread-2运行了
    线程名字：Thread-2获得锁定
    线程Thread-4运行了
    线程名字：Thread-4获得锁定
    线程Thread-3运行了
    线程名字：Thread-3获得锁定
    线程Thread-6运行了
    线程名字：Thread-6获得锁定
    线程Thread-8运行了
    线程名字：Thread-8获得锁定
    线程Thread-9运行了
    线程名字：Thread-9获得锁定
    线程Thread-5运行了
    线程名字：Thread-5获得锁定
    线程Thread-7运行了
    线程名字：Thread-7获得锁定
 */