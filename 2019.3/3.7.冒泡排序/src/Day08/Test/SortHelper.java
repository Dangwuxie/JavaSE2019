package Day08.Test;

public class SortHelper {
    public static void sort(int[] data){
        int[] dabs = data;
        for (int i = 0;i < dabs.length;i++){
            for (int j = 0;j < dabs.length-1-i;j++){
                if (dabs[j] > dabs[j+1]){
                    int temp = dabs[j+1];
                    dabs[j+1] = dabs[j];
                    dabs[j] = temp;
                }
            }
        }
    }
    public static void print(int[] data){
        for (int a: data){
            System.out.print(a+" ");
        }
    }
}
