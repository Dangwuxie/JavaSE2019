package Day18.Test;

class Water<T extends Number> {
    private T x;
    public T getX() { return x; }
    public void setX(T x) { this.x = x; }
}
public class Test7 {
    public static void main(String[] args) {
        Water<Integer> water = new Water<>();
        Water<Number> water1 = new Water<>();

    }
}
