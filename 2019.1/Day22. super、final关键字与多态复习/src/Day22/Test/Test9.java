package Day22.Test;

class Cat{ }
class XiaoMao extends Cat{ }
public class Test9 {
    public static void main(String[] args) {
        //假如没有向上转型
        Cat cat = new Cat();
        if (cat instanceof XiaoMao ){
            XiaoMao xiaoMao = (XiaoMao) cat;
        }else{
            System.out.println("无法强制类型转换");
            //建立关系
            cat = new XiaoMao();
        }
    }
}
