package Day14.Test;

/**
 * 观察wait(long)的现象；
 */
class Service4{
    public void waitLongTestMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("开始wait(long),等待5秒");
                long start = System.currentTimeMillis();
                lock.wait(5000);
                long end = System.currentTimeMillis();
                System.out.println("结束wait(long)，5秒结束");
                System.out.println("等待时间为end-start = "+(end-start)+"毫秒");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class TestThread extends Thread{
    private Object lock;

    public TestThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service4 service4 = new Service4();
        service4.waitLongTestMethod(lock);
    }
}

public class Test4 {
    public static void main(String[] args) {
        Object lock = new Object();
        TestThread t1 = new TestThread(lock);
        t1.start();
        System.out.println("t1执行完了---------");
    }
}

/*
 * 执行结果:
 * t1执行完了---------
 * 开始wait(long),等待5秒
 * 结束wait(long)，5秒结束
 * 等待时间为end-start = 5000毫秒
 */