package Day26.Test;
//线程之间的继承，优先级也是可以继承的；

class MyThread8 implements Runnable{
    @Override
    public void run() {
        new Thread(new MyThread81()).start();
        System.out.println("父线程的优先级为:"
                +Thread.currentThread().getPriority());
    }
}

class MyThread81 extends MyThread8{
    @Override
    public void run() {
        System.out.println("子线程的优先级为："
                +Thread.currentThread().getPriority());
    }
}

public class Test8 {
    public static void main(String[] args) {
        MyThread8 myThread8 = new MyThread8();
        Thread thread = new Thread(myThread8);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.start();
    }
}
