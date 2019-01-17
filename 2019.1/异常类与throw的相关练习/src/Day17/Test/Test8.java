package Day17.Test;

public class Test8 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        for (int temp : arr){
            System.out.print(temp+".");
        }
        System.out.println();
        for (int i = 0;i < 5;i++){
            System.out.print(arr[i]+"、");
        }
    }
}
