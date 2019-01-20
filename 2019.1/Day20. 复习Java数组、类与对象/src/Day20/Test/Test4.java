package Day20.Test;

public class Test4 {
    public static void main(String[] args) {
        //静态舒适化
        int[] arr4 = new int[]{1,3,5,7,9};
        System.out.println(arr4.length);
        arr4[5] = 11;
        System.out.println(arr4[5]);
    }
}
