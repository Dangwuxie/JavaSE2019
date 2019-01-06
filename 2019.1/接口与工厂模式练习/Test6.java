interface Computer{
    void funRealComputer();
}
class Client{
    public void buyComputer(Computer comp){
        comp.funRealComputer();
    };
}
class MacbookPro implements Computer{
    public void funRealComputer(){
        System.out.println("买一个苹果笔记本");
    }
}
class SurfaceBook implements Computer{
    public void funRealComputer(){
        System.out.println("买一个微软笔记本");
    }
}
class AlienWare implements Computer{
    public void funRealComputer(){
        System.out.println("买一台外星人笔记本");
    }
}
class ComputerFactory{
    public static Computer getInstance(String computerName){
        if(computerName.equals("mac")){
            return new MacbookPro();
        }else if(computerName.equals("surface")){
            return new SurfaceBook();
        }else if(computerName.equals("alienware")){
            return new AlienWare();
        }
        return null;
    }
}
public class Test6{
    //客户端（主方法）
    public static void main(String[] args){
        Client cli = new Client();
        String computerName = "mac";
        Computer computer = ComputerFactory.getInstance(computerName);
        cli.buyComputer(computer);
        
    }
}