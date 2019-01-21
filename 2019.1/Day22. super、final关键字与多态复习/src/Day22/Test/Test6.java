package Day22.Test;

class Water{
    public final Students stu = new Students();
}
class Students{
    private int i;
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
}
public class Test6 {
    public static void main(String[] args) {
        Water water = new Water();
        water.stu.setI(10);
        System.out.println(water.stu.getI());
        water.stu.setI(20);
        System.out.println(water.stu.getI());
    }
}
