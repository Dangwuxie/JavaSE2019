package Day08.Test;

import java.util.Random;

public class Test1 {

    public static void main(String[] args) {
	// write your code here
        //int[] data = new int[]{1,5,7,9,8,2,4,3};
        int[] data = Insert.generateNearlySortArray(10,2,10);
        Insert.print(data);
        /*Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        System.out.println(a+"  "+b);*/
        /*int[] data = Insert.generateArray(30000,0,1000000);
        Insert.bubbleSort(data);
        Insert.insertSort(data);
        Insert.shellSort(data);
        Insert.binaryInsertSort(data);
        Insert.selectionSort(data);
        //Insert.print(data);*/
    }
}
