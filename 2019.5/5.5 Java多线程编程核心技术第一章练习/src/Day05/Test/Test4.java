package Day05.Test;
//interrupt异常停止法，抛出个异常
//进入catch语句

class MyThread4 implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("前面的语句-----");
            Thread.sleep(3000);
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("停止了，退出------");
                    throw new InterruptedException();
                }
                System.out.println("停止后面的语句--------");

        }catch (InterruptedException e){
            System.out.println("进catch方法了");
            e.printStackTrace();
        }
    }
}
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread4 m4 = new MyThread4();
        Thread t1 = new Thread(m4);
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
        System.out.println("end-------");
    }
}
