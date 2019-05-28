package Day16.Test;

/**
 * 方法join后面的代码提前运行
 * 出现意外；
 */

class Thread7A extends Thread{
    private Thread7B thread7B;

    public Thread7A(Thread7B thread7B) {
        this.thread7B = thread7B;
    }
    @Override
    public void run() {
        try{
            synchronized (thread7B){
                System.out.println("1.A线程开始:"
                        +Thread.currentThread().getName()
                        +"   "+System.currentTimeMillis());
                Thread.sleep(100);
                System.out.println("2.A线程结束:"
                        +Thread.currentThread().getName()
                        +"   "+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Thread7B extends Thread{
    @Override
    public synchronized void run() {
        try{
            System.out.println("3.B线程开始:"
                    +Thread.currentThread().getName()
                    +"   "+System.currentTimeMillis());
            Thread.sleep(300);
            System.out.println("4.B线程结束:"
                    +Thread.currentThread().getName()
                    +"   "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        Thread7B thread7B = new Thread7B();
        Thread7A thread7A = new Thread7A(thread7B);
        thread7A.setName("A线程");
        thread7B.setName("B线程");
        thread7A.start();
        thread7B.start();
        thread7B.join(100);
        System.out.println("5.Main方法结束"+"   "+System.currentTimeMillis());
    }
}
