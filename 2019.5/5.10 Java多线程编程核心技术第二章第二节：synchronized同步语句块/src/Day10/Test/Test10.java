package Day10.Test;
//多线程的死锁观察
class Pen{
    private String pen;

    public String getPen() {
        return pen;
    }
}
class Book{
    private String book;

    public String getBook() {
        return book;
    }
}
public class Test10 {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Book book = new Book();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen){
                    System.out.println("我有笔，需要本子，"+Thread.currentThread().getName());
                    synchronized (book){
                        System.out.println("有本子，没笔");
                    }
                }
            }
        },"-----------有本子没笔的线程");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book){
                    System.out.println("有本子，需要笔，"+Thread.currentThread().getName());
                    synchronized (pen){
                        System.out.println("有笔，不给你本子");
                    }
                }

            }
        },"-------------有笔没本子的线程");
        threadA.start();
        threadB.start();
    }

}
