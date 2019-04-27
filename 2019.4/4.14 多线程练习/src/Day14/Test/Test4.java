package Day14.Test;
//使用匿名内部类进行Runnable的创建
class MyThread4 implements Runnable{
    private String name;
    public MyThread4(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println( this.name+", i ="+ i);
        }
    }
}
public class Test4 {
    public static void main(String[] args) {
        new Thread(new MyThread4("线程4")).start();
        new Thread(new MyThread4("线程5")).start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 10;i++){
                    System.out.println( "线程2"+", i ="+ i);
                }
            }
        }).start();*/
    }
}
