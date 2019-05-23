package Day16.Test;

/**
 * 观察方法join与异常的发生
 * 如果当前线程对象被中断，则当前线程出现异常
 * 调用interrupt方法之后
 */
class MyThread3A extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前数字"+(i+1));
        }
    }
}
//定义两个线程
class MyThread3B extends Thread{
    @Override
    public void run() {
        try{
            MyThread3A a = new MyThread3A();
            a.start();
            a.join();
            System.out.println("线程B在最后打印了---");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class MyThread3C extends Thread{
    private MyThread3B myThread3B;

    public MyThread3C(MyThread3B myThread3B) {
        this.myThread3B = myThread3B;
    }

    @Override
    public void run() {
        myThread3B.interrupt();
    }
}

public class Test3 {
    public static void main(String[] args) {
        try{
            MyThread3B myThread3B = new MyThread3B();
            myThread3B.start();
            Thread.sleep(500);
            MyThread3C myThread3C = new MyThread3C(myThread3B);
            myThread3C.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}



/*
 * 运行结果：
 * java.lang.InterruptedException
 * 	at java.lang.Object.wait(Native Method)
 * 	at java.lang.Thread.join(Thread.java:1252)
 * 	at java.lang.Thread.join(Thread.java:1326)
 * 	at Day16.Test.MyThread3B.run(Test3.java:28)
 * 当前数字1
 * 当前数字2
 * 当前数字3
 * 当前数字4
 * 当前数字5
 * 当前数字6
 * 当前数字7
 * 当前数字8
 * 当前数字9
 * 当前数字10
 */