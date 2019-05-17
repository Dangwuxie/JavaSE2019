package Day09.Test;
//观察单例模式中的实例变量的非线程安全状态；
//实例变量非线程安全
class HasSelfPrivateNum{
    private int num = 0;
    public synchronized void addI(String username){
        try {
            if (username.equals("a")){
                num = 100;
                System.out.println("A已经完了----");
                System.out.println("A线程 num = "+num);
                Thread.sleep(3000);
            }else{
                num = 200;
                System.out.println("B已经完了----");
                System.out.println("B线程 num = "+num);
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getNum() {
        return num;
    }
}
class MyThreadA implements Runnable{
    private HasSelfPrivateNum num;

    public MyThreadA(HasSelfPrivateNum num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("a");
    }
}
class MyThreadB implements Runnable{
    private HasSelfPrivateNum num;

    public MyThreadB(HasSelfPrivateNum num) {
        this.num = num;
    }
    @Override
    public void run() {
        num.addI("b");

    }
}
public class Test1 {

    public static void main(String[] args) {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        MyThreadA ma = new MyThreadA(num);
        MyThreadB mb = new MyThreadB(num);
        Thread ta = new Thread(ma);
        ta.start();
        Thread tb = new Thread(mb);
        tb.start();

    }
}
