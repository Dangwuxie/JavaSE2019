package Day08.Test;

import java.util.Random;

public class Test1 {

    public static void main(String[] args) {
	// write your code here
        int [] data = new int[]{9,3,7,4,1,2,6,8,5};
       // int[] data = Insert.generateArray(1000000,0,10);
        //Insert.bubbleSort(data);
        //Insert.insertSort(data);
        //Insert.selectionSort(data);
        //Insert.binaryInsertSort(data);
        //Insert.shellSort(data);
        //Insert.mergeSort(data);
        //Insert.quickSort(data);
        //Insert.quickSort2(data);
        Insert.quickSort3(data);
        Insert.print(data);
       /* Random random = new Random();
        int l = 4;
        int r = 9;
        for (int i = 0;i<50;i++){
            int x = random.nextInt(r-l)+l+1 ;
            System.out.println(x);
        }
*/
        //Insert.print(data);
    }
}
