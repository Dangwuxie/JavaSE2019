package Day26.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//等待线程停止，join()方法；
class MyThread4 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("主线程睡眠前的时间");
            Test4.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠结束的时间");
            Test4.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread4 myThread4 = new MyThread4();
        Thread thread = new Thread(myThread4,"子线程A");
        thread.start();
        System.out.println(Thread.currentThread().getName());
        //thread.join();
        System.out.println("代码结束");
    }
    public static void printTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println(time);
    }
}
