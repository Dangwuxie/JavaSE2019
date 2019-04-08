package Day08.Test;

import java.util.Random;

public class Test1 {

    public static void main(String[] args) {
	// write your code here
        int [] data = new int[]{4,7,5,1,2,9,6,8};
        //int[] data = Insert.generateNearlySortArray(100000,20);

        //int[] data = Insert.generateArray(100000,10000,200000);
        //Insert.insertSort(data);
        //Insert.binaryInsertSort(data);
        //Insert.bubbleSort(data);

        Insert.selectionSort(data);

        //Insert.shellSort(data);
        //Insert.mergeSort(data);
        //Insert.quickSort(data);
        //Insert.quickSort2(data);
        //Insert.quickSort3(data);
        //Insert.print(data);
       /* Random random = new Random();
        int l = 4;
        int r = 9;
        for (int i = 0;i<50;i++){
            int x = random.nextInt(r-l)+l+1 ;
            System.out.println(x);
        }
*/
        Insert.print(data);
    }
}
