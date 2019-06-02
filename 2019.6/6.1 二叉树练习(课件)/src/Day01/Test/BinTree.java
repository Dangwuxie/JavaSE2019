package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: BinTree
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 二叉树通用接口
 * @date 2019/6/2 0:20
 */
public interface BinTree<E> {
    /**
     * 向二叉树中添加元素
     */
    void add(E e);

    /**
     * 获得二叉树节点个数
     */
    int getSize();

    /**
     * 查找二叉树中是否包含指定元素
     */
    boolean contains(E e);

    /**
     * 二叉树前序遍历
     */
    void preOrder();

    /**
     * 二叉树中序遍历
     */

    void inOrder();

    /**
     * 二叉树后续遍历
     */

    void postOrder();

    /**
     * 层序遍历
     */

    void levelOrder();

    /**
     * 取得二叉树的最小值节点
     */
    E getMin();

    /**
     * 取得二叉树的最大值节点
     */
    E getMax();

    E removeMin();
    E removeMax();
}
