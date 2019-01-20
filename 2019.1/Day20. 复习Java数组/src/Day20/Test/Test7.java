package Day20.Test;

public class Test7 {
    public static void main(String[] args) {
        int[] arr8 = new int[]{55,12,33,30,100,99};
        char[] arr9 = new char[]{'a','e','c','b','g'};
        java.util.Arrays.sort(arr8);
        java.util.Arrays.sort(arr9);
        for (int temp : arr8){
            System.out.print(temp+" 、");
        }
        System.out.println();
        for (char ch : arr9){
            System.out.print(ch+" 、");
        }
    }
}
