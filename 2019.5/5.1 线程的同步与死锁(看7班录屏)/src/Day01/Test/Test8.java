package Day01.Test;
//死锁观察
class Pen{
    private String pen = "笔";

    public String getPen() {
        return pen;
    }
}
class Book{
    private String book = "本";

    public String getBook() {
        return book;
    }
}

public class Test8 {
    private static Pen pen = new Pen();
    private static Book book = new Book();
    public static void main(String[] args) {
        new Test8().deadLock();
    }
    public void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen){
                    System.out.println(Thread.currentThread().getName()+"有笔，没本子；");
                    synchronized (book){
                        System.out.println(Thread.currentThread().getName()+"拿到本子");
                    }
                }
            }
        },"Pen");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book){
                    System.out.println(Thread.currentThread().getName()+"有本子，没有笔；");
                    synchronized (pen){
                        System.out.println(Thread.currentThread().getName()+"拿到笔");
                    }
                }
            }
        },"Book");
        thread1.start();
        thread2.start();
    }

}
