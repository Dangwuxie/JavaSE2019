package heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dangxuchao
 * @Title: Heap
 * @ProjectName 堆
 * @Description: TODO
 * @date 2019/6/9 19:06
 */
public class Heap<E> {
    private Comparator<E> comparator;
    private int size;
    private E[] elementData;
    private static final int DEFAULT_CAPACITY = 10;

    public Heap() {
        this(DEFAULT_CAPACITY);
    }
    public Heap(int initialCapacity){
        this(initialCapacity,null);
    }

    public Heap(int initialCapacity,Comparator<E> comparator){
        this.elementData = (E[]) new Object[initialCapacity];
        this.comparator = comparator;

    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    //内部实现一个比较器
    private int compare(E o1,E o2){
        if (comparator == null){
            //此时要想两个元素之间进行比较，
            //E必须是Comparable子类
            return ((Comparable<E>) o1).compareTo(o2);
        }
        return comparator.compare(o1,o2);
    }

    //取得相应得索引下标

    /**
     * 返回当前节点得左孩子下标
     * @param index
     * @return
     */
    private int leftChildIndex(int index){
        return index*2 + 1;
    }

    /**
     * 取得右孩子得节点下标
     * @param index
     * @return
     */
    private int rightChildIndex(int index){
        return index*2 + 2;
    }

    /**
     * 取得父节点下标
     * 返回当前节点得父节点下标；
     * @param index
     * @return
     */
    private int fatherIndex(int index){
        if (index == 0)
            throw new IllegalArgumentException("当前节点没有父节点");
        return (index-1)/2;
    }

    /**
     * 扩容方法
     */
    public void add(E e){
        if (size == elementData.length){
            grow();
        }
        //向数组末尾添加元素
        elementData[size++] = e;
        //如果破坏了堆的结构，上浮元素
        //siftUp
        siftUp(size-1);
    }
    private void siftUp(int index){
        while (index > 0 && compare(elementData[index],elementData[fatherIndex(index)]) > 0){
            //交换当前节点与父节点的值
            swap(index,fatherIndex(index));
            index = fatherIndex(index);
        }
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (E e : elementData){
            if (e != null)
            res.append(e+" ");
        }
        return res.toString();
    }
    private void swap(int indexA,int indexB){
        E temp = elementData[indexA];
        elementData[indexA] = elementData[indexB];
        elementData[indexB] = temp;
    }
    private void grow(){
        int oldCap = elementData.length;
        int newCap = oldCap + (oldCap < 64 ? oldCap:oldCap>>1);
        if (newCap > Integer.MAX_VALUE-8){
            throw new IndexOutOfBoundsException("数组太大");
        }
        //拷贝新数组；
        elementData = Arrays.copyOf(elementData,newCap);
    }
    //先找到堆的最大值,但是还没有删除；
    public E findMax(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("堆是空的");
        }
        return elementData[0];
    }
    private void siftDown(int index){
        while (leftChildIndex(index) < size){
            int j = leftChildIndex(index);
            //下面判断左孩子大还是右孩子大

            if (j+1 < size){
                //此时有右孩子
                if (compare(elementData[j],elementData[j+1]) < 0){
                    j++;
                }
            }
            //此时element[j]一定是左右孩子的最大值
            if (compare(elementData[index],elementData[j]) > 0){
                break;
            }
            //交换两个下标的元素，再次下沉;
            swap(index,j);
            index = j;
        }
    }
    //取出元素(删除元素),取出堆的最大值
    public E extractMax(){
        E result = findMax();
        //第一步，交换堆顶元素与最后一个元素的位置
        swap(0,size-1);
        elementData[-- size] = null;
        siftDown(0);
        return result;

    }
}
