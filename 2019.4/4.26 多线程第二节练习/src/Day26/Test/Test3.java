package Day26.Test;
//线程让步：yield()方法

class MyThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 3;i++){
            Thread.yield();
            System.out.println("当前线程："+
                    Thread.currentThread().getName()+" i = "+i);
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        new Thread(myThread3,"线程1").start();
        new Thread(myThread3,"线程2").start();
        new Thread(myThread3,"线程3").start();
    }
}
