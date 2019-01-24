package Day20.Test;

class MyThread3 extends Thread{
    private String name;
    private int ticket = 10;
    public MyThread3(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0;i < 10;i++){
            System.out.println(this.name+"还剩下"+ticket--+" 张票");
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
            Thread threadA = new MyThread3("黄牛1");
            Thread threadB = new MyThread3("黄牛2");
            Thread threadC = new MyThread3("黄牛3");
            threadA.start();
            threadB.start();
            threadC.start();
    }
}
