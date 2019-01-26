package Day24.Test;

class MyThread extends Thread{
    private String name;
    private int ticket = 3;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println(this.name+"还剩下"+ticket--+" 张票");
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
        Thread threadA = new MyThread("黄牛1");
        Thread threadB = new MyThread("黄牛2");
        Thread threadC = new MyThread("黄牛3");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
