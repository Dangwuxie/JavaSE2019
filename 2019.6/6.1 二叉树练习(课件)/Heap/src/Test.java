import java.util.Arrays;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 二叉堆测试
 * @date 2019/6/13 13:49
 */
public class Test {
    public static void main(String[] args) {
        /*int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        Heap.upAdjust(array);
        System.out.println(Arrays.toString(array));*/

        int[] array1 = new int[]{7,1,3,10,5,2,8,9,6};
        Heap.buildHeap(array1);
        System.out.println(Arrays.toString(array1));
    }
}
