package Day21.Test;
//使用notify()方法唤醒线程
class MyThread implements Runnable{
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod(){
        synchronized (obj){
            while(true){
                try {
                    System.out.println("wait方法开始："+Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait方法结束："+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void notifyMethod(){
        synchronized (obj){
            System.out.println("notify()方法开始："+Thread.currentThread().getName());
            obj.notify();
            System.out.println("notify()方法结束："+Thread.currentThread().getName());
        }
    }
    @Override
    public void run() {
        if (flag){
            this.waitMethod();
        }else{
            this.notifyMethod();
        }
    }
}
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread waitThread = new MyThread(true,object);
        MyThread notifyThread = new MyThread(false,object);
        new Thread(waitThread,"wait线程").start();
        Thread.sleep(1000);
        new Thread(notifyThread,"notify线程").start();


    }
}
