package Day10.Test;
//数据类型Stringd的常量池特性
class Service8{
    public static void print(String stringParam){
        try {
            synchronized (stringParam){
                while (true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//两个自定义线程
class Thread8A implements Runnable{
    private Service8 service8;

    public Thread8A(Service8 service8) {
        this.service8 = service8;
    }

    @Override
    public void run() {
        service8.print("AA");
    }
}
class Thread8B implements Runnable{
    private Service8 service8;

    public Thread8B(Service8 service8) {
        this.service8 = service8;
    }

    @Override
    public void run() {
        service8.print("AA");
    }
}
public class Test8 {
    public static void main(String[] args) {
        Service8 service8 = new Service8();
        Thread t1 = new Thread(new Thread8A(service8));
        Thread t2 = new Thread(new Thread8B(service8));
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}
