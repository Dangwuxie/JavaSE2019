package Day20.Test;

import java.util.concurrent.Callable;

class MyThread4 implements Runnable{
    private String name;
    private int ticket = 10;
    public MyThread4(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0;i < 10;i++){
            System.out.println(this.name+"还剩下"+ticket--+" 张票");
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4("huangni");
        Thread threadA = new Thread(myThread4);
        Thread threadB = new Thread(myThread4);
        Thread threadC = new Thread(myThread4);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
