package Day18.Test;

class Flower<T>{
    private T x;
    public T getX() { return x; }
    public void setX(T x) { this.x = x; }
}
public class Test8 {
    public static void main(String[] args) {
        Flower<Integer> flower = new Flower<>();
        flower.setX(666666);
        Flower<Double> flower1 = new Flower<>();
        flower1.setX(77.777);
        print(flower);
        print(flower1);
    }
    public static void print(Flower<? extends Number> flower){

        System.out.println(flower.getX());
    }
}
