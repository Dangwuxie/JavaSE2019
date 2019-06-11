/**
 * @author Dangxuchao
 * @Title: Queue
 * @ProjectName 6.10 栈和队列的相关练习
 * @Description: TODO
 * @date 2019/6/10 20:42
 */
public interface Queue<E> {
    /**
     * 元素入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 元素出队
     * @return
     */
    E dequeue();

    E peek();
    int getSize();
    boolean isEmpty();
}
