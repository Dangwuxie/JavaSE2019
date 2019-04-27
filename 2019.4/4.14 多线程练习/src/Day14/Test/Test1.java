package Day14.Test;
//2.1 定义线程的主题类,并且覆写run方法；

class MyThread extends Thread{
    private String name;
    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0;i < 3;i++){
            System.out.println(this.name+", i ="+ i);
        }
    }
}
public class Test1 {

    public static void main(String[] args) {
	    MyThread myThread1 = new MyThread("线程1");
	    MyThread myThread2 = new MyThread("线程2");
	    MyThread myThread3 = new MyThread("线程3");
	    myThread1.run();
	    myThread2.run();
	    myThread3.run();
    }
}
