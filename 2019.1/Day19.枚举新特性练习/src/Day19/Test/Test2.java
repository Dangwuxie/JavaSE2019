package Day19.Test;
enum Color2{
    RED,BLUE,GREEN
}
public class Test2 {
    public static void main(String[] args) {
        Color2 color2 = Color2.RED;
        System.out.println(color2.ordinal()+" "+color2.name());
        for (Color2 color3 :Color2.values()){
            System.out.println(color3);
        }
    }
}
