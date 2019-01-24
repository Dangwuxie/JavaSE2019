package Day24.Test;

class MyThread2 extends Thread{
    private int ticket2 = 10;
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+
            "还剩下"+this.ticket2--+"票");
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyThread2 my = new MyThread2();
        Thread thread = new Thread(my);
        my.start();
        thread.start();
    }
}
