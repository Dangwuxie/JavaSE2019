package Day16.Test;

/**
 * 验证join方法释放锁的特点
 */

class Thread6A extends Thread{
    private Thread6B thread6B;

    public Thread6A(Thread6B thread6B) {
        this.thread6B = thread6B;
    }

    @Override
    public void run() {
        try{
            synchronized (thread6B){
                thread6B.start();
                thread6B.join(4000);

                System.out.println("sleep不释放锁------");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Thread6B extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("B线程的开始"+System.currentTimeMillis()+"----");
            Thread.sleep(3000);
            System.out.println("B线程的结束"+System.currentTimeMillis()+"----");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void bService(){
        System.out.println("调用一下B线程里的另外一个同步方法；"+System.currentTimeMillis());
    }
}

class Thread6C extends Thread{
    private Thread6B thread6B;

    public Thread6C(Thread6B thread6B) {
        this.thread6B = thread6B;
    }

    @Override
    public void run() {
        thread6B.bService();
    }
}
public class Test6{
    public static void main(String[] args) throws InterruptedException {
        Thread6B b = new Thread6B();
        Thread6A a = new Thread6A(b);
        a.start();
        Thread.sleep(1000);
        Thread6C c = new Thread6C(b);
        c.start();
    }
}

/*
    运行结果：

    B线程的开始1558787599534----
    调用一下B线程里的另外一个同步方法；1558787600533
    sleep不释放锁------
            B线程的结束1558787602534----

            实验多次证明，一旦在A线程里面B线程启动后调用了join(long)方法，
            就会立即（几乎是立即）交出锁，
   */