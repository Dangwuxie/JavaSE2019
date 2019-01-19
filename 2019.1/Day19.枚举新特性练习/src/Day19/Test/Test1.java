package Day19.Test;
class Color{
    private String title;
    //多例要区分几个对象谁是谁；
    //构造方法私有化
    public static final int RED_FLAG = 1;
    public static final int BLUE_FLAG = 5;
    public static final int GREEN_FLAG = 10;
    private static final Color RED = new Color("Red");
    private static final Color BLUE = new Color("Blue");
    private static final Color GREEN = new Color("Green");
    private Color(String title){
        this.title = title;
    }
    public static Color getInstance(int flag){
        switch (flag){
            case RED_FLAG:
                return RED;
            case BLUE_FLAG:
                return BLUE;
            case GREEN_FLAG:
                return GREEN;
            default:
                return null;
        }
    }
    //覆写tostring方法
    public String toString(){
        return this.title;
    }
}
public class Test1 {
    public static void main(String[] args) {
        Color color = Color.getInstance(Color.RED_FLAG);
        System.out.println(color);
    }
}
