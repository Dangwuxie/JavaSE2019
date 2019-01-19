package Day19.Test;
enum Color4{
    RED("红"),BLUE("蓝"),GREEN("绿");
    private String name;
    private Color4(String name){
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
    public String getName(){
        return this.name;
    }
}
public class Test3 {
    public static void main(String[] args) {
        Color4 color4 = Color4.RED;
        System.out.println(color4);
    }
}
