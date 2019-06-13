import java.util.Comparator;

/**
 * @author Dangxuchao
 * @Title: Heap
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 二叉堆的实现
 * @date 2019/6/13 13:49
 */
public class Heap<E extends Comparator> {
    /**
     * 二叉堆的上浮操作
     * @param array
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex-1)/2;
        //temp先保存一下堆末尾，也就是数组最后插入的数字
        //以便最后的赋值
        int temp = array[childIndex];
        while (childIndex>0 && temp<array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 堆的下沉操作
     * @param array  要调整的数组
     * @param parentIndex 要下沉的节点
     * @param length 堆的有效大小
     */
    public static void aownAdjust(int[] array,int parentIndex,int length){
        //同样先保存要调整的节点；
        int temp = array[parentIndex];
        //找出子节点的下标,先找出左孩子节点
        int childIndex = parentIndex*2+1;
        while (childIndex < length){
            //有左孩子的时候，先判断是否有有孩子并且有孩子的值是否比左孩子的值小，
            //如果右孩子的值比左孩子的值小，则定位到右孩子上面；
            if (childIndex + 1 < length && array[childIndex]>array[childIndex+1]){
                childIndex++;
            }
            //当父节点小于任何一个孩子的值的时候，直接跳出此while循环；
            if (temp <= array[childIndex])
                break;
            //此时直接单向赋值
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array){
        //构建一个二叉堆，就是从最后一个非叶子节点依次下沉；
        for (int i = (array.length-2)/2;i >= 0;i--){
            aownAdjust(array,i,array.length);
        }
    }
}
