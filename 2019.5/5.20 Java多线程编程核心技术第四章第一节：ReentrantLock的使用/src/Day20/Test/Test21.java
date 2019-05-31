package Day20.Test;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * awaitUntil()：
 * 造成当前线程在接到信号、被中断或到达指定最后期限之前一直处于等待状态;
 * 与此条件相关的锁以原子方式释放。
 */


class Service21{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void waitMethod(){
        try{
            Calendar calendarRef = Calendar.getInstance();
            calendarRef.add(Calendar.SECOND,10);
            lock.lock();
            System.out.println("wait方法开始时间："+System.currentTimeMillis());
            condition.awaitUntil(calendarRef.getTime());
            System.out.println("wait方法结束时间："+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void notifyMethod(){
        try{
            lock.lock();
            System.out.println("notify方法开始时间："+System.currentTimeMillis());
            condition.signalAll();
            System.out.println("notify方法结束时间："+System.currentTimeMillis());
        }finally {
            lock.unlock();
        }
    }
}

class Thread21A extends Thread{
    private Service21 service21;

    public Thread21A(Service21 service21) {
        this.service21 = service21;
    }

    @Override
    public void run() {
        service21.waitMethod();
    }
}

class Thread21B extends Thread{
    private Service21 service21;

    public Thread21B(Service21 service21) {
        this.service21 = service21;
    }

    @Override
    public void run() {
        service21.notifyMethod();
    }
}
public class Test21 {
    public static void main(String[] args) throws InterruptedException {
        Service21 service21 = new Service21();
        Thread21A thread21A = new Thread21A(service21);
        thread21A.start();
        Thread.sleep(2000 );
        Thread21B thread21B = new Thread21B(service21);
        thread21B.start();
    }
}
/*
    运行结果：

    wait方法开始时间：1559297033594
    notify方法开始时间：1559297035544
    notify方法结束时间：1559297035544
    wait方法结束时间：1559297035544

 */