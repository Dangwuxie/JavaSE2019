interface USB{
    void setUp();
    void work();
}
class Computer{
    public void plugin(USB sub){
        sub.setUp();
        sub.work();
    }
}
class UDisk implements USB{
    public void setUp(){
        System.out.println("U盘安装驱动。。。");
    }
    public void work(){
        System.out.println("开始工作使用");
    }
}
class KeyBoard implements USB{
    public void setUp(){
        System.out.println("键盘安装驱动。。。");
    }
    public void work(){
        System.out.println("键盘正常工作");
    }
}
public class Test5{
    public static void main(String[] args){
        Computer comp = new Computer();
        comp.plugin(new UDisk());
        comp.plugin(new KeyBoard());
    }
}