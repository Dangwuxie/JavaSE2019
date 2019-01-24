package Day24.Test;

class MyThread4 extends Thread{
    private int ticket2 = 10;
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    "还剩下"+i);
        }
    }
}
public class Test4 {
    public static void main(String[] args) {
        MyThread4 ms = new MyThread4();
        Thread thread1 = new Thread(ms,"A线程");
        Thread thread2 = new Thread(ms,"B线程");
        Thread thread3 = new Thread(ms,"C线程");
        thread1.start();;
        thread2.start();
        thread3.start();
    }
}
