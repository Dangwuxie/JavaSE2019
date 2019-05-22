package Day14.Test;

/**执行该方法后，当前线程不会立即释放该对象锁，
 * 呈wait状态的线程也并不会马上获取该对象锁，
 * 要等待执行notify方法的线程将程序执行完，
 * 也就是退出同步块之后线程才会释放锁
 */
class Service{
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin wait :"+Thread.currentThread().getName());
                lock.wait();
                System.out.println("end  wait :"+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void synNotifyMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin notify wait :"
                        +Thread.currentThread().getName()+"time = "+System.currentTimeMillis());
                lock.notify();
                Thread.sleep(3000);
                System.out.println("end notify wait :"
                        +Thread.currentThread().getName()+"time = "+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadA extends Thread{
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
class NotifyThread extends Thread{
    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}
class synNotifyThread extends Thread{
    private Object lock;

    public synNotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}


public class Test2 {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
        synNotifyThread c = new synNotifyThread(lock);
        c.start();

    }
}


/*
 * 执行结果：
 * begin wait :Thread-0
 * begin notify wait :Thread-1time = 1558349922279
 * end notify wait :Thread-1time = 1558349925327
 * end  wait :Thread-0
 * begin notify wait :Thread-2time = 1558349925329
 * end notify wait :Thread-2time = 1558349928330
 */