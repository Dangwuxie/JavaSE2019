package heap;

/**
 * @author Dangxuchao
 * @Title: Test1
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: TODO
 * @date 2019/6/9 20:11
 */
public class Test1 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        int[] nums = new int[]{62,41,30,28,16,22,13,19,17,15};
        for (int i : nums){
            heap.add(i);
        }
        heap.add(52);
        heap.extractMax();
        System.out.println(heap);
    }
}
