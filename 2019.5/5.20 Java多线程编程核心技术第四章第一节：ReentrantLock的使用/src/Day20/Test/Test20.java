package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *之前子线程调用start方法后如果又调用了interrupt方法来中断线程
 * 那么此时会抛出异常
 * 所以可以调用awaitUninterruptibly()方法来解决此问题；
 * 造成当前线程在接到信号之前一直处于等待状态，
 * 与此条件相关的锁以原子方式释放
 */

class MyService20{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void testMethod(){
        try{
            lock.lock();
            System.out.println("wait方法开始");
            condition.awaitUninterruptibly();
            System.out.println("wait方法结束");
        }finally {
            lock.unlock();
        }
    }
}

//自定义一个线程
class Thread20 extends Thread{
    private MyService20 myService20;

    public Thread20(MyService20 myService20) {
        this.myService20 = myService20;
    }

    @Override
    public void run() {
        myService20.testMethod();
    }
}
public class Test20 {
    public static void main(String[] args) {
        try {
            MyService20 myService20 = new MyService20();
            Thread20 thread20 = new Thread20(myService20);
            thread20.start();
            Thread.sleep(3000);
            thread20.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
