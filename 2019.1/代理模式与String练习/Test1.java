//首先要有一个接口，先定义一个行为
interface IBuy{
    void buyBuyBuy();
}
//然后要有两个子类实现它
//真实主题类，真正要掏钱的人
class RealSubject implements IBuy{
    public void buyBuyBuy(){
        System.out.println("买一台mac");
    }
}
//代理类
//辅助操作的类
//就是真正付款之前代理类要干的事情
class ProxySubject implements IBuy{
    private IBuy buyer;
    public ProxySubject(IBuy buyer){
        this.buyer = buyer;
    }
    public void beforeBuy(){
        System.out.println("排队");
    }
    public void buyBuyBuy(){
        this.beforeBuy();
        //真实主题类完成真实操作；
        this.buyer.buyBuyBuy();
        this.afterBuy();
    }
    public void afterBuy(){
        System.out.println("发快递到客户手中");
    }
}
public class Test1{
    public static void main(String[] args){
        //客户端中
        //代理类帮忙辅助操作跑腿；
        //只需要在付款的时候把真实类传进去；
        new ProxySubject(new RealSubject()).buyBuyBuy();
    }
}