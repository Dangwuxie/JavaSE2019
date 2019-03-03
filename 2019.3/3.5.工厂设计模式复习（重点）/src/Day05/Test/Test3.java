package Day05.Test;
//工厂方法模式；
interface Computer3{
    void buyComputer();
}
class MacBook3 implements Computer3{
    @Override
    public void buyComputer() {
        System.out.println("买一台MACBOOK");
    }
}
class SurfaceBook3 implements Computer3{
    @Override
    public void buyComputer() {
        System.out.println("买一台SURFACEBOOK");
    }
}
interface ComputerFactory{
    Computer3 creatComputer();
}
class MacBook3Creat implements ComputerFactory{
    @Override
    public Computer3 creatComputer() {
        return new MacBook3();
    }
}
class SurfaceBookCreat implements ComputerFactory{
    @Override
    public Computer3 creatComputer() {
        return new SurfaceBook3();
    }
}
class Client3{
    public void buyComputer(Computer3 computer3){
        computer3.buyComputer();
    }
}
public class Test3 {
    public static void main(String[] args) {
        Client3 client3 = new Client3();
        ComputerFactory computerFactory = new SurfaceBookCreat();
        client3.buyComputer(computerFactory.creatComputer());
    }
}
