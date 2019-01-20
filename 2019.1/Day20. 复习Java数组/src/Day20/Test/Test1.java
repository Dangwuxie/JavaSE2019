package Day20.Test;

public class Test1 {

    public static void main(String[] args) {
	    //动态初始化声明一个数组
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int temp : arr){
            System.out.print(temp+"、");
        }
    }
}
