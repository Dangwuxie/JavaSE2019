package Day05.Test;
//守护线程观察
class MyThread12 implements Runnable{
    private int i = 0;
    @Override
    public void run() {

        try {
            while (true){
                i++;
                System.out.println("i = "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test12 {
    public static void main(String[] args) throws InterruptedException {
        MyThread12 myThread12 = new MyThread12();
        Thread t12 = new Thread(myThread12);
        t12.setDaemon(true);
        t12.start();
        Thread.sleep(5000);
        System.out.println("停止了");
    }
}
