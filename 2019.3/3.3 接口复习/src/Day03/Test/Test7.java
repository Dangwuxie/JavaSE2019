package Day03.Test;
//接口描述标准；
interface  USB{
    void setup();
    void work();
}
class Computer{
    public void plugin(USB usb){
        usb.setup();
        usb.work();
    }
}
class UDisk implements USB{
    @Override
    public void setup() {
        System.out.println("安装U盘驱动");
    }
    @Override
    public void work() {
        System.out.println("U盘开始工作");
    }
}
class PrintDisk implements USB{
    @Override
    public void setup() {
        System.out.println("安装打印机驱动");
    }

    @Override
    public void work() {
        System.out.println("打印机开始工作");
    }
}
//测试类
public class Test7 {
    public static void main(String[] args) {
       Computer computer = new Computer();
       computer.plugin(new UDisk());
       computer.plugin(new PrintDisk());
    }
}
