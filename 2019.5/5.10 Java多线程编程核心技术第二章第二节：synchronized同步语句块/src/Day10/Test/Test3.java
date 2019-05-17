package Day10.Test;
//使用其他实例来作为对象监视器实现同步的功能；
class Service3{
    private String anyString = new String();
    public void print(){
        try {

            synchronized (anyString){
                System.out.println("线程名字为："
                        +Thread.currentThread().getName()
                        +"在"+System.currentTimeMillis()+"进入同步块");
                Thread.sleep(2000);
                System.out.println("线程名字为："
                        +Thread.currentThread().getName()
                        +"在"+System.currentTimeMillis()+"退出同步块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread3A implements Runnable{
    private Service3 service3;

    public Thread3A(Service3 service3) {
        this.service3 = service3;
    }

    @Override
    public void run() {
        service3.print();
    }
}
class Thread3B implements Runnable{
    private Service3 service3;

    public Thread3B(Service3 service3) {
        this.service3 = service3;
    }

    @Override
    public void run() {
        service3.print();
    }
}
public class Test3 {
    public static void main(String[] args) {
        Service3 service3 = new Service3();
        Thread t1 = new Thread(new Thread3A(service3));
        Thread t2 = new Thread(new Thread3B(service3));
        t1.start();
        t2.start();
    }
}
