package Day17.Test;
public class Test7 {
    public static void main(String[] args) {
        System.out.println(add(new int[]{1,3,5}));
        System.out.println(add(new int[]{1,3,5,7}));
        System.out.println(add(new int[]{1,3}));
        System.out.println(add(1,2,3));
        System.out.println(add(3,2,1));
    }
    public static int add(int ... data){
        int sum = 0;
        for(int temp : data){
            sum+=temp;
        }
        return sum;
    }
}
