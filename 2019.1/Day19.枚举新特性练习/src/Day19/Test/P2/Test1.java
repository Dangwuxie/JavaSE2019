package Day19.Test.P2;
interface IColor{
    public String color();
}
enum Color implements IColor{
    RED("红"),BLUE("蓝"),GREEN("绿");
    private String name;
    private Color(String name){
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
    public String color(){
        return this.name;
    }
}
public class Test1 {
    public static void main(String[] args) {
        IColor iColor = Color.BLUE;
        System.out.println(((Color) iColor).color());
    }
}
