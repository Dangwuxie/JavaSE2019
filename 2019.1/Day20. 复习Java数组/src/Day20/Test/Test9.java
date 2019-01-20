package Day20.Test;

import java.util.Arrays;

public class Test9 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,4,5,6,7,8,9};
        int[] x = num1;
        int[] num2 = Arrays.copyOf(x,9);
        for (int temp : num2){
            System.out.print(temp+" 、");
        }
    }
}
