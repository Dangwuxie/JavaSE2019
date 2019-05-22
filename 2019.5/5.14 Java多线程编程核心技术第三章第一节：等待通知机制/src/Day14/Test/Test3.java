package Day14.Test;

/**
 * 异常观察：
 * 当线程呈wait状态时，调用线程对象的interrupt方法
 * 会出现InterruptedException异常
 * 实际上出现的异常是：
 * java.lang.IllegalMonitorStateException；
 */

class Service3{
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("wait方法开始");
                lock.wait();
                System.out.println("wait方法结束");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("出现异常了，因为呈wait状态的线程被interrupt了");
        }
    }
}
class Thread3A extends Thread{
    private Object lock;

    public Thread3A(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service3 service3 = new Service3();
        service3.testMethod(lock);
    }
}


public class Test3 {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            Thread3A a = new Thread3A(lock);
            a.start();
            Thread.sleep(5000);
            a.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 * 执行结果：
 * wait方法开始
 * 出现异常了，因为呈wait状态的线程被interrupt了
 * java.lang.InterruptedException
 * 	at java.lang.Object.wait(Native Method)
 * 	at java.lang.Object.wait(Object.java:502)
 * 	at Day14.Test.Service3.testMethod(Test3.java:16)
 * 	at Day14.Test.Thread3A.run(Test3.java:35)
 */