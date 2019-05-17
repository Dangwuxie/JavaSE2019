package Day10.Test;
//观察对象监视器不是同一个时
//运行出现异步执行的情况
class Service4{
    private String anyString = new String();
    public void a(){
        synchronized (anyString){
            try {
                synchronized (anyString){
                    System.out.println("a begin");
                    Thread.sleep(2000);
                    System.out.println("a end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized public void b(){
        System.out.println("b begin");
        System.out.println("b end");
    }
}

class Thread4A implements Runnable{
    private Service4 service4;

    public Thread4A(Service4 service4) {
        this.service4 = service4;
    }
    @Override
    public void run() {
        service4.a();
    }
}
class Thread4B implements Runnable{
    private Service4 service4;

    public Thread4B(Service4 service4) {
        this.service4 = service4;
    }
    @Override
    public void run() {
        service4.b();
    }
}
public class Test4 {
    public static void main(String[] args) {
        Service4 service4 = new Service4();
        Thread t1 = new Thread(new Thread4A(service4));
        Thread t2 = new Thread(new Thread4B(service4));
        t1.start();
        t2.start();
    }
}
