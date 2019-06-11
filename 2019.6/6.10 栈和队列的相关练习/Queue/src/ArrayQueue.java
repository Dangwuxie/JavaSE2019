import java.util.Arrays;

/**
 * @author Dangxuchao
 * @Title: ArrayQueue
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 基于数组的顺序队列
 *
 * @date 2019/6/10 20:44
 */
public class ArrayQueue<E> implements Queue<E> {
    //存放数据的数组

    private E[] elementData;

    //队列头
    private int head;
    //队列尾
    private int tail;
    //队列容量
    private int capacity;

    /**
     * 构造方法初始化顺序队列容量
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        elementData = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) {
        if (tail == capacity-1){
            //如果此时队列容量满了，就扩容
            int oldCapacity = capacity;
            int newCapacity = oldCapacity << 1;
            if (((newCapacity + 8) - Integer.MAX_VALUE) > 0){
                throw new OutOfMemoryError("超出可存储范围");
            }
            capacity = newCapacity;
            elementData = Arrays.copyOf(elementData,newCapacity);
        }
        elementData[tail++] = e;
    }

    /**
     * 如果不停的出对入队，那么head指针就会不同往后移动，当tail移动到最右边时
     * 队列的前面却空出了很多，可是也无法往队列中添加数据了
     * 此时我们可以这样，当tail=capacity时，先判断head是否为0，
     * 如果为0，那么队列已满，否则触发一次数据的整体搬移，从head-tail之间的元素
     * 搬到0-(tail-head)的位置；
     *
     * @param e
     */
    public void enqueue2(E e){
        if (tail == capacity){
            if (head == 0){
                throw new ArrayIndexOutOfBoundsException("队列已经满了");
            }else {
                //否则发生一次数据搬移
                for (int i = head;i < tail;i++){
                    elementData[i-head] = elementData[i];
                }
                //搬移完毕之后更新两个指针位置
                tail -= head;
                head = 0;
            }
        }
    }
    @Override
    public E dequeue() {
        if (head == tail){
            throw new ArrayIndexOutOfBoundsException("队列为空");

        }
        E result = elementData[head++];
        return result;
    }

    @Override
    public E peek() {
        return elementData[head];
    }

    @Override
    public int getSize() {
        return tail-head;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }
}
