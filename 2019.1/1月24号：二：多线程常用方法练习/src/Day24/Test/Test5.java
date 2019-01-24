package Day24.Test;
//yield()方法
class MyThread5 extends Thread{
    private int ticket2 = 10;
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+
                    "还剩下"+i);
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
        MyThread5 ms = new MyThread5();
        Thread thread1 = new Thread(ms,"A线程");
        Thread thread2 = new Thread(ms,"B线程");
        Thread thread3 = new Thread(ms,"C线程");
        thread1.start();;
        thread2.start();
        thread3.start();
    }
}
