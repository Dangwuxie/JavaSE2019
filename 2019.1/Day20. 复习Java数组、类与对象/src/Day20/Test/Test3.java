package Day20.Test;

public class Test3 {
    public static void main(String[] args) {
        //引用传递
        int[] arr2 = new int[3];
        arr2[0] = 11;
        arr2[1] = 22;
        int[] arr3 = arr2;
        arr3[2] = 33;
        System.out.println(arr2[2]);
    }
}
