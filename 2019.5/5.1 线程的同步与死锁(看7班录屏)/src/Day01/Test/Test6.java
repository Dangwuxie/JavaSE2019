package Day01.Test;
//锁住Class类;

class Sync6{
    public void fun(){
        synchronized (Sync.class){
            System.out.println(Thread.currentThread().getName()
                    +"开始执行。。。");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    +"结束执行。。。");
        }
    }
}
class MyThread6 implements Runnable{
    @Override
    public void run() {
        Sync6 sync6 = new Sync6();
        sync6.fun();
    }
}
public class Test6 {
    public static void main(String[] args) {
        Sync6 sync6 = new Sync6();
        MyThread6 myThread6 = new MyThread6();
        new Thread(myThread6,"线程A").start();
        new Thread(myThread6,"线程B").start();
        new Thread(myThread6,"线程C").start();
    }
}
