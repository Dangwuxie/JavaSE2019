package Day09.Test;
//观察同步不可以继承的情况，两个线程会出现非同步调用，
// 子类加锁synchronized之后就可以同步了

class Father5{
    synchronized public void father(){
        try {
            System.out.println("开始father当前线程名称:"
                    +Thread.currentThread().getName()+
                    "时间："+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("结束father当前线程名称:"
                    +Thread.currentThread().getName()+
                    "时间："+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Son5 extends Father5{
    @Override
    public void father() {
        try {
            System.out.println("开始son当前线程名称:"
                    +Thread.currentThread().getName()+
                    "时间："+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("结束son当前线程名称:"
                    +Thread.currentThread().getName()+
                    "时间："+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread5A implements Runnable{
    private Son5 son5;

    public MyThread5A(Son5 son5) {
        this.son5 = son5;
    }

    @Override
    public void run() {
        son5.father();
    }
}
class MyThread5B implements Runnable{
    private Son5 son5;

    public MyThread5B(Son5 son5) {
        this.son5 = son5;
    }

    @Override
    public void run() {
        son5.father();
    }
}
public class Test5 {
    public static void main(String[] args) {
        Son5 son5 = new Son5();
        Thread t1 = new Thread(new MyThread5A(son5));
        Thread t2 = new Thread(new MyThread5B(son5));
        t1.setName("线程1");
        t2.setName("线程2");
        //子类并没有继承父类的方法的同步性；
        t1.start();
        t2.start();
    }
}
