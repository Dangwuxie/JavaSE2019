package Day01.Test;
//synchronized锁住多对象；
//第一种方法：共享一个对象；

class Sync{
    public synchronized void fun(){
        System.out.println(Thread.currentThread().getName()+"开始执行。。。");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束执行。。。");
    }
}


class MyThread5 implements Runnable{
    private Sync sync;

    public MyThread5(Sync sycn) {
        this.sync = sycn;
    }

    @Override
    public void run() {
        this.sync.fun();
    }
}
public class Test5 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        MyThread5 myThread6 = new MyThread5(sync);
        new Thread(myThread6,"线程A").start();
        new Thread(myThread6,"线程B").start();
        new Thread(myThread6,"线程C").start();
    }
}
