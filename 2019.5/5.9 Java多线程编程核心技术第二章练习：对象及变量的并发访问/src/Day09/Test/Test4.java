package Day09.Test;
//观察存在父子类继承关系时，子类是完全可以通过“可重入锁”调用父类的同步方法的；

class Person {
    public int i = 10;
    synchronized public void farther(){
        try {
            i--;
            System.out.println("farther = "+ i);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Son extends Person{
    synchronized public void son(){
        try {
            while (i > 0){
                i--;
                System.out.println("Son = "+i);
                Thread.sleep(1000);
                this.farther();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread4 implements Runnable{
    @Override
    public void run() {
        Son son = new Son();
        son.son();
    }
}
public class Test4 {
    public static void main(String[] args) {
        new Thread(new MyThread4()).start();
    }
}
