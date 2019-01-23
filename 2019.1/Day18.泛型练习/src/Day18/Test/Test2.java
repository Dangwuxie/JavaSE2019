package Day18.Test;

class Point<T> {
    private T x;
    private T y;
    public T getX() { return x; }
    public void setX(T x) { this.x = x; }
    public T getY() { return y; }
    public void setY(T y) { this.y = y; }
}
public class Test2 {
    public static void main(String[] args) {
        Point<String> point = new Point<String>();
        point.setX("张三");
        Point<Integer> point1 = new Point<Integer>();
        point1.setX(666);
    }
}
