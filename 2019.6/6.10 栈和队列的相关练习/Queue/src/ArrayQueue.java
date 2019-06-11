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
