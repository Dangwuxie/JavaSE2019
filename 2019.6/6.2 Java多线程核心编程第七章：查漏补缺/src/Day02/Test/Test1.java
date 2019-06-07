package Day02.Test;

/**
 * 验证NEW RUNNABLE  TERMINATED三个状态;
 */

class Thread1 extends Thread{
    public Thread1() {
        System.out.println("构造方法中的状态："
                +Thread.currentThread().getState());
    }
    @Override
    public void run() {
        System.out.println("run方法中的状态："
                +Thread.currentThread().getState());
    }
}
public class Test1 {

    public static void main(String[] args) {
        try{
            Thread1 thread1 = new Thread1();
            System.out.println("main方法中的状态1："
                    + thread1.getState());
            Thread.sleep(1000);
            thread1.start();
            Thread.sleep(1000);
            System.out.println("main方法中的状态2："
                    +thread1.getState());
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}
/*
运行结果：

    构造方法中的状态：RUNNABLE
    main方法中的状态1：NEW
    run方法中的状态：RUNNABLE
    main方法中的状态2：TERMINATED
 */