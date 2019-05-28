package Day20.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock关键字实现线程之间同步互斥；
 */

class MyService{
    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();
        for (int i = 0;i < 3;i++){
            System.out.println("ThreadName = "+Thread.currentThread().getName());
        }
        lock.unlock();
    }
}
class MyThread1 extends Thread{
    private MyService myService;

    public MyThread1(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
public class Test1 {

    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread1 a1 = new MyThread1(myService);
        MyThread1 a2 = new MyThread1(myService);
        MyThread1 a3 = new MyThread1(myService);
        MyThread1 a4 = new MyThread1(myService);
        a1.start();
        a2.start();
        a3.start();
        a4.start();

    }
}
/*
    运行结果：

    ThreadName = Thread-0
    ThreadName = Thread-0
    ThreadName = Thread-0
    ThreadName = Thread-1
    ThreadName = Thread-1
    ThreadName = Thread-1
    ThreadName = Thread-2
    ThreadName = Thread-2
    ThreadName = Thread-2
    ThreadName = Thread-3
    ThreadName = Thread-3
    ThreadName = Thread-3

    由运行结果可以看出线程之间的执行是同步的；
 */