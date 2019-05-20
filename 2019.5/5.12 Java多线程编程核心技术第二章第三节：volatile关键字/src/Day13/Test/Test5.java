package Day13.Test;
/**
 * synchronized代码块有volatile同步的功能
 * 将线程工作内存中的私有变量与公共内存中的变量同步的功能；
 */
class Service5{
    private boolean isContinueRun = true;
    String anything = new String();
    public void runMethod(){
        while (isContinueRun == true){
            //此处要是不加上synchronized
            //就会一直停在这个死循环里
            //这是由于各线程之间的数据值没有可视性造成的，
            //而关键字可以具有可视性；
            /*synchronized (anything){

            }*/
        }
        System.out.println("停下来了");
    }
    public void stopMethod(){
        isContinueRun = false;
    }
}
//定义两个线程
class Thtread5A implements Runnable{
    private Service5 service5;

    public Thtread5A(Service5 service5) {
        this.service5 = service5;
    }

    @Override
    public void run() {
        service5.runMethod();
    }
}
class Thtread5B implements Runnable{
    private Service5 service5;

    public Thtread5B(Service5 service5) {
        this.service5 = service5;
    }

    @Override
    public void run() {
        service5.stopMethod();
    }
}
public class Test5 {
    public static void main(String[] args) {
        try {
            Service5 service5 = new Service5();
            Thread tA = new Thread(new Thtread5A(service5));
            tA.start();
            Thread.sleep(1000);
            Thread tB = new Thread(new Thtread5B(service5));
            tB.start();
            System.out.println("已经发起停止的命令了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
