package Day10.Test;
//观察：不再synchronized块中就是异步执行，
// 在synchronized块中就是同步执行；
//非同步时交叉打印，同步时排队执行；
class Task{
    public void donLongTimeTask(){
        for (int i = 0;i < 10;i++){
            System.out.println("没有同步的代码块:线程名字 = "
                    +Thread.currentThread().getName()+" i = "+(i+1));
        }
        System.out.println("----------------------");
        synchronized (this){
            for (int i = 0;i < 10;i++){
                System.out.println("同步代码块：线程名字 = "
                        +Thread.currentThread().getName()+" i = "+(i+1));
            }
        }
    }
}
class MyThread1A implements Runnable{
    private Task task;

    public MyThread1A(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.donLongTimeTask();
    }
}
class MyThread1B implements Runnable{
    private Task task;

    public MyThread1B(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.donLongTimeTask();
    }
}
public class Test1 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(new MyThread1A(task));
        Thread t2 = new Thread(new MyThread1B(task));
        t1.setName("线程1");

        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
