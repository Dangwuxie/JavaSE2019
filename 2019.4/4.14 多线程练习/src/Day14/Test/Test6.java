package Day14.Test;
//继承Tread类进行卖票，此处是每人十张票或者共享十张票的情况;
class MyThread5 extends Thread{
    private String name;
    private Integer ticket ;
    public MyThread5(String name,Integer ticket) {
        this.name = name;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println( this.name+"剩余票数："+ticket--);
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        new MyThread5("黄牛A",10).start();
        new MyThread5("黄牛B",10).start();
        new MyThread5("黄牛C",10).start();

    }
}
