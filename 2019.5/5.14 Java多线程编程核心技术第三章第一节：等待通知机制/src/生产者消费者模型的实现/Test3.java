package 生产者消费者模型的实现;

import java.util.ArrayList;
import java.util.List;

/**
 * 一生产与一消费：操作栈；
 * 向堆栈List对象中放入数据，使消费者
 * 从堆栈中取出数据。
 * List的最大容量为1；
 */
class MyStack3{
    private List list = new ArrayList();
    synchronized public void push(){
        try{
            if (list.size() == 1){
                System.out.println(Thread.currentThread().getName()+"等待消费");
                this.wait();
            }
            list.add("Apple");
            System.out.println(Thread.currentThread().getName()+"生产商品"+list.get(0));
            this.notify();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void pop(){
        try{
            if (list.size() == 0){
                System.out.println(Thread.currentThread().getName()+"等待生产");
                this.wait();
            }
            list.remove(0);
            System.out.println(Thread.currentThread().getName()+"已经消费，当前商品个数为"+list.size());
            this.notify();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
//生产者消费者
class P3{
    private MyStack3 myStack3;

    public P3(MyStack3 myStack3) {
        this.myStack3 = myStack3;
    }
    public void pushService(){
        myStack3.push();
    }
}
class C3{
    private MyStack3 myStack3;

    public C3(MyStack3 myStack3) {
        this.myStack3 = myStack3;
    }
    public void popService(){
        myStack3.pop();
    }
}
//创建生产者和消费者线程
class P_Thread implements Runnable{
    private P3 p3;

    public P_Thread(P3 p3) {
        this.p3 = p3;
    }

    @Override
    public void run() {
        while (true){
            p3.pushService();
        }
    }
}
class C_Thread implements Runnable{
    private C3 c3;

    public C_Thread(C3 c3) {
        this.c3 = c3;
    }

    @Override
    public void run() {
        while (true){
            c3.popService();
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        MyStack3 stack3 = new MyStack3();
        P3 p3 = new P3(stack3);
        C3 c3 = new C3(stack3);
        P_Thread p_thread = new P_Thread(p3);
        C_Thread c_thread = new C_Thread(c3);
        Thread p_Thread = new Thread(p_thread);
        Thread c_Thread = new Thread(c_thread);
        p_Thread.start();
        c_Thread.start();


    }
}
