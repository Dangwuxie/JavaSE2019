package Day10.Test;
//synchronized(X.Class)方式来锁住Class对象

class Service7{
    public static void printA(){
        synchronized (Service7.class){
            try {
                System.out.println("线程名称为："
                        +Thread.currentThread().getName()
                        +" 在 "+System.currentTimeMillis()+",进入printA");
                Thread.sleep(1000);
                System.out.println("线程名称为："
                        +Thread.currentThread().getName()
                        +" 在 "+System.currentTimeMillis()+",离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void printB(){
        synchronized (Service7.class){
            System.out.println("线程名称为："
                    +Thread.currentThread().getName()
                    +" 在 "+System.currentTimeMillis()+"进入printB");
            System.out.println("线程名称为："
                    +Thread.currentThread().getName()
                    +" 在 "+System.currentTimeMillis()+"离开printB");
        }
    }
    synchronized public void printC(){
        System.out.println("线程名称为："
                +Thread.currentThread().getName()
                +" 在 "+System.currentTimeMillis()+"进入printC");
        System.out.println("线程名称为："
                +Thread.currentThread().getName()
                +" 在 "+System.currentTimeMillis()+"离开printC");
    }
}
//自定义三个线程
class Thread7A implements Runnable{
    private Service7 service7;

    public Thread7A(Service7 service7) {
        this.service7 = service7;
    }

    @Override
    public void run() {
        service7.printA();
    }
}
class Thread7B implements Runnable{
    private Service7 service7;

    public Thread7B(Service7 service7) {
        this.service7 = service7;
    }

    @Override
    public void run() {
        service7.printB();
    }
}
class Thread7C implements Runnable{
    private Service7 service7;

    public Thread7C(Service7 service7) {
        this.service7 = service7;
    }

    @Override
    public void run() {
        service7.printC();
    }
}
public class Test7 {
    public static void main(String[] args) {
        Service7 service7 = new Service7();
        Thread t1 = new Thread(new Thread7A(service7));
        Thread t2 = new Thread(new Thread7B(service7));
        Thread t3 = new Thread(new Thread7C(service7));
        t1.start();
        t2.start();
        t3.start();
    }
}
