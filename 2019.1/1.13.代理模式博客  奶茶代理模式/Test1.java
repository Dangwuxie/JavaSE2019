//首先，写个接口
interface MilkyTea{
    public void buyMilkyTea();
}
//然后就是第一个子类，决定什么口味的奶茶
class MilkyTeaTaste implements MilkyTea{
    public void buyMilkyTea(){
        System.out.println("要一杯巧克力口味的");
    }
}
class MilkyTeaTaste2 implements MilkyTea{
    public void buyMilkyTea(){
        System.out.println("要一杯红豆口味的奶茶");
    }
}
//下面事第二个子类(店员)，用来辅助这个过程
class MilkyTeaEmplyee implements MilkyTea{
    private MilkyTea milktea;
    public MilkyTeaEmplyee(MilkyTea milktea){
        this.milktea = milktea;
    }
    public void joinCondiments(){
        System.out.println("加入调味品");
    }
    public void heatMilkyTea(){
        System.out.println("加热奶茶");
    }
    public void packMilkTea(){
        System.out.println("装入杯中");
    }
    public void buyMilkyTea(){
        this.milktea.buyMilkyTea();
        this.joinCondiments();
        this.heatMilkyTea();
        this.packMilkTea();
    }
}
public class Test1{
    public static void main(String[] args){
        new MilkyTeaEmplyee(new MilkyTeaTaste()).buyMilkyTea();
        new MilkyTeaEmplyee(new MilkyTeaTaste2()).buyMilkyTea();
    }
}