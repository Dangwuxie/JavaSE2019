package Day04.Test;
//线程停止和线程唤醒
class MyThread implements Runnable{
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }
    public void waitMethod(){
        synchronized (obj){
            try {
                System.out.println(Thread.currentThread().getName()
                        +"wait方法开始。。。");
                obj.wait();
                System.out.println(Thread.currentThread().getName()
                        +"wait方法结束。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void notifyMethod(){
        synchronized (obj){
            try{
                System.out.println(Thread.currentThread().getName()
                        +"notify方法开始。。。");
                obj.notify();
                System.out.println(Thread.currentThread().getName()
                        +"notify方法结束。。。");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        if (flag){
            this.waitMethod();
        }else {
            this.notifyMethod();
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        Object obj = new Object();
        MyThread waitThread1 = new MyThread(true,obj);
        MyThread waitThread2 = new MyThread(true,obj);
        MyThread notifyThread = new MyThread(false,obj);
        Thread thread1 = new Thread(waitThread1,"wait1线程");
        Thread thread2 = new Thread(waitThread2,"wait2线程");
        Thread thread3 = new Thread(notifyThread,"notify线程");
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
        System.out.println("main方法结束。。。");
    }
}
