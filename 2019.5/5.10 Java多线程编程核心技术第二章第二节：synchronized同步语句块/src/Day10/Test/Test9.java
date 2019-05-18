package Day10.Test;
//同步块解决同步方法容易造成死锁的问题；
class Service9{
    Object object1 = new Object();
    public void methodA(){
        synchronized (object1){
            System.out.println("A begin");
            boolean temp = true;
            while (temp){
                System.out.println( "A" );
            }
            System.out.println("A end");
        }
    }
    Object object2 = new Object();
    public void methodB(){
        synchronized (object2){
            System.out.println("B begin");
            System.out.println("B end");
        }
    }
}
class Thread9A implements Runnable{
    private Service9 service9;

    public Thread9A(Service9 service9) {
        this.service9 = service9;
    }

    @Override
    public void run() {
        service9.methodA();
    }
}
class Thread9B implements Runnable{
    private Service9 service9;

    public Thread9B(Service9 service9) {
        this.service9 = service9;
    }

    @Override
    public void run() {
        service9.methodB();
    }
}
public class Test9 {
    public static void main(String[] args) {
        Service9 service9 = new Service9();
        Thread t1 = new Thread(new Thread9A(service9));
        Thread t2 = new Thread(new Thread9B(service9));
        t1.start();
        t2.start();
    }
}
