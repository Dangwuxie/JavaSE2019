package Day10.Test;
//锁住类的Class对象

class Service6{
    synchronized public static void printA(){
        try {
            System.out.println("线程名称为："
                    +Thread.currentThread().getName()
                    +" 在 "+System.currentTimeMillis()+"进入printA");
            Thread.sleep(1000);
            System.out.println("线程名称为："
                    +Thread.currentThread().getName()
                    +" 在 "+System.currentTimeMillis()+"离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public static void printB(){
        System.out.println("线程名称为："
                +Thread.currentThread().getName()
                +" 在 "+System.currentTimeMillis()+"进入printB");
        System.out.println("线程名称为："
                +Thread.currentThread().getName()
                +" 在 "+System.currentTimeMillis()+"离开printB");
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
class Thread6A implements Runnable{
    private Service6 service6;

    public Thread6A(Service6 service6) {
        this.service6 = service6;
    }

    @Override
    public void run() {
        service6.printA();
    }
}
class Thread6B implements Runnable{
    private Service6 service6;

    public Thread6B(Service6 service6) {
        this.service6 = service6;
    }

    @Override
    public void run() {
        service6.printB();
    }
}
class Thread6C implements Runnable{
    private Service6 service6;

    public Thread6C(Service6 service6) {
        this.service6 = service6;
    }

    @Override
    public void run() {
        service6.printC();
    }
}

public class Test6 {
    public static void main(String[] args) {
        Service6 service6 = new Service6();
        Thread t1 = new Thread(new Thread6A(service6));
        Thread t2 = new Thread(new Thread6B(service6));
        Thread t3 = new Thread(new Thread6C(service6));
        t1.start();
        t2.start();
        t3.start();
    }
}
