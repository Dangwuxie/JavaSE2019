package 生产者消费者模型的实现;

import java.util.ArrayList;
import java.util.List;
/**
 * 多生产与一消费--操作栈
 * 向堆栈List对象中放入数据，使消费者
 * 从堆栈中取出数据。
 * List的最大容量为1；
 */
class MyStack4{
    private List list = new ArrayList();
    public void push(){
            synchronized (this){
                try{
                    while (list.size() == 4){
                        System.out.println(Thread.currentThread().getName()
                                +"当前有货了等待消费");
                        this.wait();

                    }
                    Thread.sleep(500);
                    list.add("Apple");
                    System.out.println(Thread.currentThread().getName()
                            +"生产一个产品，当前产品数量为"+list.size());

                    this.notifyAll();

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
    public void pop(){
            synchronized (this){
                try{
                    while (list.size() == 0){
                        System.out.println(Thread.currentThread().getName()
                                +"没货，等待生产");
                        this.wait();
                    }
                    Thread.sleep(500);
                    list.remove(0);
                    System.out.println(Thread.currentThread().getName()
                            +"消费了一个产品，商品池数量为"+list.size());
                    this.notifyAll();


                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
}
//生产者消费者
class P4{
    private MyStack4 myStack4;

    public P4(MyStack4 myStack4) {
        this.myStack4 = myStack4;
    }
    public void pushService(){
        myStack4.push();
    }

}
class C4{
    private MyStack4 myStack4;

    public C4(MyStack4 myStack4) {
        this.myStack4 = myStack4;
    }
    public void popService(){
        myStack4.pop();
    }
}
//创建生产者和消费者线程
class P_Thread4 implements Runnable{
    private P4 p4;

    public P_Thread4(P4 p4) {
        this.p4 = p4;
    }

    @Override
    public void run() {
        while (true){
            p4.pushService();
        }
    }
}
class C_Thread4 implements Runnable{
    private C4 c4;

    public C_Thread4(C4 c4) {
        this.c4 = c4;
    }

    @Override
    public void run() {
        while (true){
            c4.popService();
        }
    }
}

public class Test4 {
    public static void main(String[] args) {
        MyStack4 myStack4 = new MyStack4();
        C4 c4 = new C4(myStack4);
        P4 p4 = new P4(myStack4);
        List<Thread> listThread = new ArrayList<>();
        for (int i = 0;i < 3;i++){
            listThread.add(new Thread(new P_Thread4(p4)));
            listThread.add(new Thread(new C_Thread4(c4)));
        }
        for (Thread o : listThread){
            o.start();
        }
    }
}
