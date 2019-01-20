package Day20.Test;
class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.println(this.name+"、"+i);
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        myThread1.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
