package Day16.Test;

/**
 * 演示sleep方法具有不释放锁的特点；
 *
 */
class Thread5A extends Thread{
    private Thread5B thread5B;

    public Thread5A(Thread5B thread5B) {
        this.thread5B = thread5B;
    }

    @Override
    public void run() {
        try{
            synchronized (thread5B){
                thread5B.start();
                Thread.sleep(6000);
                System.out.println("sleep不释放锁------");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
class Thread5B extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("B线程的开始"+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("B线程的结束"+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void bService(){
        System.out.println("调用一下B线程里的另外一个同步方法；"+System.currentTimeMillis());
    }
}

class Thread5C extends Thread{
    private Thread5B thread5B;

    public Thread5C(Thread5B thread5B) {
        this.thread5B = thread5B;
    }

    @Override
    public void run() {
        thread5B.bService();
    }
}
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Thread5B b = new Thread5B();
        Thread5A a = new Thread5A(b);
        a.start();
        Thread.sleep(1000);
        Thread5C c = new Thread5C(b);
        c.start();
    }
}


 /*
   运行结果：

  B线程的开始1558623812333
            B线程的结束1558623815333
sleep不释放锁------
        调用一下B线程里的另外一个同步方法；1558623818324

       注意最后C线程调用B线程另一个同步方法的时间，
       一直从B线程开始执行等了6秒，
       可是B线程3秒已经执行完了；
       这是因为A线程持有B线程类对象的锁6秒
       所以只有在A线程6秒结束释放B对象的锁的时候
       才能调用ThreadB中的另外一个同步方法；

       此实验证明sleep方法不释放锁；

        */