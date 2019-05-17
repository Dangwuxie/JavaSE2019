package Day10.Test;

import java.util.ArrayList;
import java.util.List;

//当线程A和B执行带有分支判断的方法时，
//就会出现逻辑上的错误，有又可能出现脏读；
class MyOneList{
    private List list = new ArrayList();
    synchronized public void add(String data){
        list.add(data);
    }
    synchronized public int getSize(){
        return  list.size();
    }
}

class MyService{
    public MyOneList addServiceMethod(MyOneList list,String data){
        try {
            //此处若不加同步块，就会出现脏读；
            if (list.getSize() < 1){
                Thread.sleep(1000);
                list.add(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
//创建两个线程

class Thread5A implements Runnable{
    private MyOneList list;

    public Thread5A(MyOneList myOneList) {
        this.list = myOneList;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list,"A");

    }
}
class Thread5B implements Runnable{
    private MyOneList list;

    public Thread5B(MyOneList myOneList) {
        this.list = myOneList;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list,"B");

    }
}
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        MyOneList list = new MyOneList();
        Thread t1 = new Thread(new Thread5A(list));
        Thread t2 = new Thread(new Thread5B(list));
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("listSize = "+list.getSize());
    }
}
