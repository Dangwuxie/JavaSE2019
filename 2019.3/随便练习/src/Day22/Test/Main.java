package Day22.Test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] data = new int[]{5,1,7,3,4,9,10};
        Arrays.sort(data);
        for (int o : data){
            System.out.print(o+" ");
        }
    }
}
