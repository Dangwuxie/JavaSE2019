package Day20.Test;

public class Test8 {
    public static void main(String[] args) {
        int[] data1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] data2 = new int[]{11,22,33,44,55,66,77,88,99,100};
        //把55 66 77 挪到2，3，4的位置；
        System.arraycopy(data2,3,data1,1,3);
        for (int temp : data1){
            System.out.print(temp+"、");
        }
    }
}
