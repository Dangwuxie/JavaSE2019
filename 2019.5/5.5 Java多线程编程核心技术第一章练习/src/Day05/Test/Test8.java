package Day05.Test;
//suspend/resume方法的使用练习
class MyThread8 implements Runnable{
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            i++;
        }
    }
}

public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        MyThread8 myThread8 = new MyThread8();
        Thread t8 = new Thread(myThread8);
        t8.start();
        Thread.sleep(2000);
        //第一段A段
        t8.suspend();
        System.out.println("A = "+System.currentTimeMillis()+" i = "+myThread8.getI());
        Thread.sleep(2000);
        System.out.println("A = "+System.currentTimeMillis()+" i = "+myThread8.getI());
        //第二段B段
        t8.resume();
        Thread.sleep(2000);
        //第三段C段
        t8.suspend();
        System.out.println("B = "+System.currentTimeMillis()+" i = "+myThread8.getI());
        Thread.sleep(2000);
        System.out.println("B = "+System.currentTimeMillis()+" i = "+myThread8.getI());
        t8.resume();
    }
}
