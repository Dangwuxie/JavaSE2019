package Day05.Test;
//使用return也可以停止线程

class MyThread7 implements Runnable{
    @Override
    public void run() {
        while(true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("线程终止了-------");
                return;
            }
            System.out.println("时间 = "+System.currentTimeMillis());
        }
    }
}
public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        MyThread7 myThread7 = new MyThread7();
        Thread thread7 = new Thread(myThread7);
        thread7.start();
        Thread.sleep(2000);
        thread7.interrupt();
    }
}
