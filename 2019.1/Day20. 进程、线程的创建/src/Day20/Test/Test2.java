package Day20.Test;
class MyThread1 implements Runnable{
    private String name;
    public MyThread1(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0;i < 3;i++){
            System.out.print(this.name+"、"+i);
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("D");
        MyThread myThread2 = new MyThread("B");
        Thread threadA = new Thread(myThread1);
        Thread threadB = new Thread(myThread2);
        threadA.start();
        threadB.start();
    }
}
