package Day17.Test;
class Dog{
    private Object x;
    private Object y;
    public Object getX() {
        return x;
    }
    public void setX(Object x) {
        this.x = x;
    }
    public Object getY() {
        return y;
    }
    public void setY(Object y) {
        this.y = y;
    }
}
public class Test9 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        /*dog.setX(10);
        dog.setY(20);
        int x = (Integer) dog.getX();
        int y = (Integer) dog.getY();
        System.out.println(x);
        System.out.println(y);
        dog.setX("夏天");
        dog.setY("冬天");
        String str1 = (String) dog.getX();
        String str2 = (String) dog.getY();
        System.out.println(str1);
        System.out.println(str2);*/
        dog.setX(10);
        dog.setY("冬天");
        String str3 = (String) dog.getX();
        String str4 = (String) dog.getY();
        System.out.println(str3);
        System.out.println(str4);
    }
}


