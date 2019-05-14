package Day05.Test;
//方法stop与java.lang.ThreadDeath异常观察；

class MyThread5 implements Runnable{
    @Override
    public void run() {
        try{
            Thread.currentThread().stop();
        }catch (ThreadDeath e){
            System.out.println("进入了catch()方法");
            e.printStackTrace();
        }
    }
}

public class Test5 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread5());
        thread.start();
    }
}
