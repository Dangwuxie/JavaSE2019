package Day06.Test;
//代理设计模式；
interface Factory{
    //定义一个接口来实现代理和真实业务类
    void buyBuybuy();
}
class RealBuy implements Factory{
    @Override
    public void buyBuybuy() {
        System.out.println("负责出钱买一台");
    }
}
class ProxyBuy implements Factory{
    private Factory realBuy;
    public ProxyBuy(Factory realbuy) {
        this.realBuy = realbuy;
    }
    public void beginBuy(){
        System.out.println("购买电脑之前的一系列行动");
    }
    public void afterBuy(){
        System.out.println("购买电脑之后的售后");
    }

    @Override
    public void buyBuybuy() {
        beginBuy();
        this.realBuy.buyBuybuy();
        afterBuy();
    }
}
class FactoryComputer{
    public  static Factory produceComputer(){
        return new ProxyBuy(new RealBuy());
    }
}
public class Test1 {

    public static void main(String[] args) {
	    Factory factory = FactoryComputer.produceComputer();
	    factory.buyBuybuy();
    }
}
