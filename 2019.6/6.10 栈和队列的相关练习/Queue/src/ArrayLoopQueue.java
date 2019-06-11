/**
 * @author Dangxuchao
 * @Title: ArrayLoopQueue
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: 基于数组的循环队列
 * @date 2019/6/11 12:51
 */
public class ArrayLoopQueue<E> implements Queue<E> {
    private E[] elementData;
    private int head;
    private int tail;
    private int size;

    public ArrayLoopQueue(int capacity) {
        //因为循环队列会浪费一个空间来判断当前队列是否已满；
        //所以需要多开辟一块空间
        elementData = (E[]) new Object[capacity+1];
    }

    /**
     * 入队操作
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //首先判断队列是否已满
        if ((tail+1)%elementData.length == head){
            throw new ArrayIndexOutOfBoundsException("队列已经满了");
        }else {
            elementData[tail] = e;
            tail = (tail+1)%elementData.length;
            size++;
        }
    }

    /**
     * 出队操作
     * @return
     */
    @Override
    public E dequeue() {
        //判断是否为空
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("队列为空");
        }else {
            E result = elementData[head];
            elementData[head] = null;
            head = (head+1)%elementData.length;
            size--;
            return result;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("队列为空");
        }
        return elementData[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 输出循环队列的所有元素
     */
    public void printAll(){
        int p = head;
        while (elementData[p] != null){
            System.out.print(elementData[p]+" ");
            p = (p+1)%elementData.length;
        }
    }
}
