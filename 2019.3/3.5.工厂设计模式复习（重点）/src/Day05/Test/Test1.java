package Day05.Test;

interface Computer{
    void realBuyComputer();
}
class MacBook implements Computer{
    @Override
    public void realBuyComputer() {
        System.out.println("买一台MACBOOK笔记本");
    }
}
class AlienBook implements Computer{
    @Override
    public void realBuyComputer() {
        System.out.println("买一台AlienBook笔记本");
    }
}
class SurfaceBook implements Computer{
    @Override
    public void realBuyComputer() {
        System.out.println("买一台SurfaceBook笔记本");
    }
}
class Client{
    public void buyComputer(Computer computer){
        computer.realBuyComputer();
    }
}
public class Test1 {
    public static void main(String[] args) {
	    Client client = new Client();
	    client.buyComputer(new AlienBook());
	    client.buyComputer(new SurfaceBook());
	    client.buyComputer(new MacBook());
    }
}
