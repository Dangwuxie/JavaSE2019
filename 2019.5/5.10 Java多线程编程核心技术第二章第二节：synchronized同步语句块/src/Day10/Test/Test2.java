package Day10.Test;
//验证synchronized(this)是锁定当前对象的

class Task2{
    public void otherMecthod(){
        System.out.println("随便打印点东西");
    }
    public void donLongTimeTask(){
        synchronized (this){
            for (int i = 0;i < 10;i++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("同步的线程名字："
                        +Thread.currentThread().getName()+" i = "+(i+1));
            }
        }
    }
}
class MyThread2A implements Runnable{
    private Task2 task2;

    public MyThread2A(Task2 task2) {
        this.task2 = task2;
    }

    @Override
    public void run() {
        task2.donLongTimeTask();
    }
}
class MyThread2B implements Runnable{
    private Task2 task2;

    public MyThread2B(Task2 task2) {
        this.task2 = task2;
    }

    @Override
    public void run() {
        task2.otherMecthod();
        task2.donLongTimeTask();
    }
}
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Task2 task2 = new Task2();
        Thread t1 = new Thread(new MyThread2A(task2));
        Thread t2 = new Thread(new MyThread2B(task2));
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
