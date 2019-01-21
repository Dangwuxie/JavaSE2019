package Day22.Test;

class Worf{
    public void print(){
        System.out.println("我是爸爸");
    }
}
class XiaoWorf extends Worf{
    public void print(){
        System.out.println("我是儿子");
    }
}
public class Test7 {
    public static void main(String[] args) {
        //向上转型，自动的
        //Worf worf = new XiaoWorf();
        //worf.print();
        //向下转型，需要强转
        Worf worf = new Worf();
        XiaoWorf xiaoWorf = (XiaoWorf) worf;
        xiaoWorf.print();
    }
}