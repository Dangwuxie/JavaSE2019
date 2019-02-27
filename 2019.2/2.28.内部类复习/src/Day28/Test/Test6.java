package Day28.Test;

//内部类分类：成员内部类；
//新建一个内部类对象；
class WaiBu{
    class NeiBu{
        public void fun(){
            System.out.println("6666666");
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        //在外部类外部创建内部类对象；
        WaiBu.NeiBu neiBu = new WaiBu().new NeiBu();
    }

}
