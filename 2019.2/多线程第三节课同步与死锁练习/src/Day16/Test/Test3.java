package Day16.Test;

class Sync{
    //表示任意时刻只有一个线程可以进入此方法；
    //默认锁得是当前对象；
    public static synchronized void fun(){
        System.out.println(Thread.currentThread().getName()+"fun方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"fun方法结束");
    }
}
class MyThread3 implements Runnable{
    private Sync sync;
    public MyThread3(Sync sync){
        this.sync = sync;
    }
    @Override
    public void run(){
        this.sync.fun();
    }
}
public class Test3 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        MyThread3 mt = new MyThread3(sync);
        Thread thread1 = new Thread(mt,"线程A");
        Thread thread2 = new Thread(mt,"线程B");
        Thread thread3 = new Thread(mt,"线程C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
