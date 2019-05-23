package Day16.Test;

/**
 * 观察join方法的使用
 */

class MyThread2 extends Thread{
    @Override
    public void run() {
        try{
            int secondValue2 = (int) (Math.random()*1000);
            System.out.println("子线程输出了："+secondValue2);
            Thread.sleep(secondValue2);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 thread2Test = new MyThread2();
        thread2Test.start();
        thread2Test.join();
        System.out.println("等thread1Test执行后再执行-------");
        System.out.println("但子线程里面的sleep（）不知道写多少---");
    }
}
