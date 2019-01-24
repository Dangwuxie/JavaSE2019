package Day24.Test;

class MyThreat implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+
            "还剩下"+this.ticket--+"张票");
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
	    MyThreat mt = new MyThreat();
	    Thread thread = new Thread(mt,"A");
	    Thread thread1 = new Thread(mt,"B");
	    Thread thread2 = new Thread(mt,"C");
	    thread1.setName("张三");
	    thread.start();
	    thread1.start();
	    thread2.start();
    }
}
