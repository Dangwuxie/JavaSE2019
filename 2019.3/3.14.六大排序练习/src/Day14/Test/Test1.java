package Day14.Test;

public class Test1 {

    public static void main(String[] args) {
	// 主测试类
        int[] data = new int[]{5,3,7,6,2,4,9,8};
        //SixSortTest.bubbleSort(data);
        //SixSortTest.insertSort(data);
        //SixSortTest.binaryInsertSort(data);
        SixSortTest.shellSort(data);
        SixSortTest.printArray(data);

    }
}
