package Day28.Test;
//观察synchronized锁住当前对象，以及锁住多对象；

class Sync {
    public synchronized void fun(){
        System.out.println("fun方法开始：当前线程为："
                +Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fun方法结束：当前线程为："
                +Thread.currentThread().getName());
    }
}
class MyThread4 implements Runnable{
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.fun();
    }
}
public class Test4 {
    public static void main(String[] args) {
        MyThread4 mt = new MyThread4();
        Thread t1 = new Thread(mt,"线程A");
        Thread t2 = new Thread(mt,"线程B");
        Thread t3 = new Thread(mt,"线程C");
        t1.start();
        t2.start();
        t3.start();
    }
}
