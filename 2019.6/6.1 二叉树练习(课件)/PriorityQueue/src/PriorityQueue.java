import java.util.Arrays;

/**
 * @author Dangxuchao
 * @Title: PriorityQueue
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 利用堆实现优先队列
 * @date 2019/6/13 14:28
 */
public class PriorityQueue {
    public int[] array;
    //数组元素的个数
    private int size;

    public PriorityQueue() {
        this.array = new int[5];
    }

    public void enQueue(int key){
        //如果队列长度超出范围就扩容；
        if (size>=array.length){
            resize();
        }
        array[size++] = key;
        //每次如多一个元素，都上浮操作；
        //保证出队列的时候出的是最大值；堆顶；
        upAdjust();
    }

    /**
     * 出队列
     */
    public int deQueue() throws Exception {
        if (size <= 0){
            throw new Exception("空队列");
        }
        //如果不为空队列，获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶，然后下沉操作；
        array[0] = array[--size];
        downAdjust();
        return head;
    }
    public void resize(){
        int oldSize = size;
        int newSize = oldSize << 1;
        if (newSize-8 > Integer.MAX_VALUE){
            throw new ArrayIndexOutOfBoundsException("超出范围");
        }
        array = Arrays.copyOf(array,newSize);
    }
    public void upAdjust(){
        //上浮操作
        int childIndex = array.length - 1;
        int temp = array[childIndex];
        int parentIndex = (childIndex-1)/2;
        while (childIndex > 0 && array[parentIndex] < temp){
            //直接单向覆盖，大于插入节点的节点都往下沉；
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = temp;
    }
    public void downAdjust(){
        //下沉操作，将array[0]的元素进行下沉；
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            //下沉第一步，选择左右孩子中最小的，如果比其大，就单向赋值
            if (childIndex+1 < size && array[childIndex] < array[childIndex+1]){
                childIndex++;
            }
            //当父节点大于任何一个孩子的值时，直接跳出
            if (temp >= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        array[parentIndex] = temp;

    }
}
