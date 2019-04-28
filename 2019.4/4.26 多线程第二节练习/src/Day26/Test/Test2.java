package Day26.Test;
//线程休眠sleep();
class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+
                    Thread.currentThread().getName()+"  i = "+i);
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        new Thread(myThread2).start();
        new Thread(myThread2).start();
    }
}
