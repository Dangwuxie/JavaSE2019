package Day16.Test;

class Sync4{
    public synchronized void testA(){
        //线程1进入A方法；
    }
    //线程2能否进入testB方法？
    public synchronized void testB(){ }
}
public class Test4 {
    public static void main(String[] args) {

    }
}
