package Day09.Test;
//观察多个对象多个锁
class HasSelfPrivateNum2{
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
class MyThreadA2 implements Runnable{
    private HasSelfPrivateNum2 num;

    public MyThreadA2(HasSelfPrivateNum2 num) {
        this.num = num;
    }

    @Override
    public void run() {
        num.addI("a");
    }
}
class MyThreadB2 implements Runnable{
    private HasSelfPrivateNum2 num;

    public MyThreadB2(HasSelfPrivateNum2 num) {
        this.num = num;
    }
    @Override
    public void run() {
        num.addI("b");

    }
}
public class Test2 {
    public static void main(String[] args) {
        HasSelfPrivateNum2 num1 = new HasSelfPrivateNum2();
        HasSelfPrivateNum2 num2 = new HasSelfPrivateNum2();
        MyThreadA2 ma2 = new MyThreadA2(num1);
        MyThreadB2 mb2 = new MyThreadB2(num2);
        Thread ta = new Thread(ma2);
        ta.start();
        Thread tb = new Thread(mb2);
        tb.start();
    }
}
