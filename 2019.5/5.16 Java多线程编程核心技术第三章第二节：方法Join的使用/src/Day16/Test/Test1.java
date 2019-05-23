package Day16.Test;

/**
 * 使用join方法的必要性
 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        try{
            int secondValue = (int) (Math.random()*10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Test1 {

    public static void main(String[] args) {
        MyThread1 thread1Test = new MyThread1();
        thread1Test.start();
        System.out.println("等thread1Test执行后再执行-------");
        System.out.println("但子线程里面的sleep（）不知道写多少---");
    }
}
