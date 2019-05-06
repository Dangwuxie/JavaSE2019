package Day04.Test;
//notifyAll方法一次唤醒所有的等待线程；

class MyThread3 implements Runnable{
    private boolean flag;
    private Object object;

    public MyThread3(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    public void waitMethod(){
        synchronized (object){
            try {
                System.out.println(Thread.currentThread().getName()
                        +"wait方法开始");
                object.wait();
                System.out.println(Thread.currentThread().getName()
                        +"wait方法结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyAllMethod(){
        synchronized (object){
            try{
                System.out.println(Thread.currentThread().getName()
                        +"notifyAll方法开始");
                object.notifyAll();
                System.out.println(Thread.currentThread().getName()
                        +"notifyAll方法结束");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        if (flag){
            this.waitMethod();
        }else{
            this.notifyAllMethod();
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        Object object = new Object();
        MyThread3 myThread1 = new MyThread3(true,object);
        MyThread3 myThread2 = new MyThread3(true,object);
        MyThread3 myThread3 = new MyThread3(true,object);
        MyThread3 myThread4 = new MyThread3(false,object);
        Thread thread1 = new Thread(myThread1,"线程1");
        Thread thread2 = new Thread(myThread2,"线程2");
        Thread thread3 = new Thread(myThread3,"线程3");
        Thread thread4 = new Thread(myThread4,"线程4");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread4.start();
        System.out.println("main方法结束-------------");
    }
}
