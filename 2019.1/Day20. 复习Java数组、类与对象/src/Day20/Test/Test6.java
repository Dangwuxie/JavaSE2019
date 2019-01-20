package Day20.Test;

public class Test6 {
    public static void main(String[] args) {
        int[] arr6 = new int[]{1,3,5,7,9,10};
        printArray(arr6);
        int[] arr7 = init();
        printArray(arr7);
        modify(arr7);
        printArray(arr7);
    }
    public static void printArray(int[] data){
        for (int temp : data){
            System.out.print(temp+"、");
        }
        System.out.println();
    }
    public static int[] init(){
        return new int[]{11,22,33,44,55,66};
    }
    public static void modify(int[] data){
        data[3] = 123;
        data[2] = 321;
    }
}
