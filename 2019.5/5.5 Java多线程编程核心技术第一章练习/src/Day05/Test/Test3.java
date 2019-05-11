package Day05.Test;
//测试当前线程的interrupted/isInterrupted两种结果

class MyThread3 implements Runnable{
    @Override
    public void run() {
        System.out.println("子线程："+Thread.interrupted());
        System.out.println("子线程："+Thread.interrupted());
    }
}
public class Test3 {
    public static void main(String[] args) {
        MyThread3 m3 = new MyThread3();
        Thread t1 = new Thread(m3);
        t1.start();
        t1.interrupt();
        System.out.println(t1.isInterrupted());

    }
}
