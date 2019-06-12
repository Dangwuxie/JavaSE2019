/**
 * @author Dangxuchao
 * @Title: BInTree
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 二叉树接口定义
 * @date 2019/6/12 12:19
 */
public interface BinTree<E> {
    /**
     * 向二叉树中添加元素
     * @param E
     */
    void add(E e);

    /**
     * 取得二叉树节点的个数
     * @return
     */
    int getSize();

    /**
     * 查找二叉树中是否包含指定元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 二叉树的前序遍历
     */
    void preOrder();

    /**
     * 中序遍历
     */
    void inOrder();

    /**
     * 后续遍历
     */
    void postOrder();

    /**
     * 层序遍历
     */
    void levleOrder();

    /**
     * 取得小值节点
     * @return
     */
    E getMin();

    /**
     * 取得最大值节点；
     * @return
     */
    E getMax();
    E removeMin();
    E removeMax();
}
