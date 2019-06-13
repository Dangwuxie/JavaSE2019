import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dangxuchao
 * @Title: BinSearchTree
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: 二分搜索树的实现
 * 二分搜索树，左子树的所有节点都要小于其父节点
 * 右子树的所有节点都要大于其父节点；
 * @date 2019/6/12 12:37
 */
public class BinSearchTree<E extends Comparable> implements BinTree<E> {
    /**
     * 内部使用链表实现
     */
    private class Node{
        private E data;
        private Node leftChild;
        private Node rightChild;

        public Node(E e) {
            this.data = e;
        }
    }

    private Node root;
    private int size;

    public BinSearchTree() {
        super();
    }

    @Override
    public void add(E e) {
        if (root == null){
            Node node = new Node(e);
            root = node;
            size++;
        }
        add(root,e);
    }
    private void add(Node root,E e){
        if (e.equals(root.data)){
            return;
        }else if (e.compareTo(root.data) < 0&& root.leftChild == null){
                Node newNode = new Node(e);
                root.leftChild = newNode;
                size++;
        }else if (e.compareTo(root.data) > 0&& root.rightChild == null){
            Node newNode = new Node(e);
            root.rightChild = newNode;
            size++;
        }
        //如果大于或者小于当前节点的并且该节点还有左右子树
        //继续往下递归，直到其要插入的元素找到合适位置就行；
        if (e.compareTo(root.data)<0){
            add(root.leftChild,e);
        }
        if (e.compareTo(root.data)>0){
            add(root.rightChild,e);
        }
    }

    /**
     * 返回节点个数，就是插入的元素个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(E e) {

        return contains(root,e);
    }

    /**
     * 内部私有方法继续往下遍历,
     * 结束条件就是当前节点为空；
     * @param root
     * @param e
     * @return
     */
    private boolean contains(Node root,E e){
        if (root == null){
            return false;
        }
        if (e.equals(root.data)){
            return true;
        }
        else if (e.compareTo(root.data)<0){
            //否则如果此时要查找的元素比当前节点小，就往它的左子树继续递归查找
            return contains(root.leftChild,e);
        }else{
            //此时就只能是大于当前节点了；
            return contains(root.rightChild,e);
        }
    }

    /**
     * 前序遍历
     */
    @Override
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }
    /**
     * 中序遍历
     */
    @Override
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.leftChild);
        System.out.print(root.data+" ");
        inOrder(root.rightChild);
    }
    /**
     * 后序遍历
     */
    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data+" ");
    }
    /**
     * 基于队列实现的二分搜索树层序遍历
     * 层序遍历，广度优先遍历
     */
    @Override
    public void levleOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if (node.leftChild != null){
                queue.add(node.leftChild);
            }
            if (node.rightChild != null){
                queue.add(node.rightChild);
            }
        }
    }

    /**
     * 二叉查找树的特性可知，最左边的叶子节点为最小的节点
     * 最右边的叶子节点则是最大的节点；
     * 所以一直往下找就行，直到左右子树再也走不下去了，则此节点即为所求；
     * @return
     */
    @Override
    public E getMin() {
        if (size == 0){
            throw new IllegalArgumentException("二叉树已经空了");
        }

        return getMinNode(root).data;
    }
    private Node getMinNode(Node node){
        if (node.leftChild == null){
            return node;
        }
        return getMinNode(node.leftChild);
    }
    @Override
    public E getMax() {
        if (size == 0){
            throw new IllegalArgumentException("二叉树已经空了");
        }

        return getMaxNode(root).data;
    }
    private Node getMaxNode(Node node){
        if (node.rightChild == null){
            return node;
        }
        return getMaxNode(node.rightChild);
    }
    @Override
    public E removeMin() {
        E result = getMin();
        root = removeMinNode(root);
        return result;
    }
    private Node removeMinNode(Node node){
        if (node.leftChild == null){
            Node rightChild = node.rightChild;
            node.rightChild = null;
            size--;
            return rightChild;
        }
        node.leftChild = removeMinNode(node.leftChild);
        return node;
    }

    @Override
    public E removeMax() {
        E result = getMax();
        //返回删除后的树的根节点；
        root = removeMaxNode(root);
        return result;
    }

    private Node removeMaxNode(Node node){
        if (node.rightChild == null){
            Node leftNode = node.leftChild;
            node.leftChild = null;
            size--;
            return leftNode;
        }
        node.rightChild = removeMaxNode(node.rightChild);
        return node;
    }

    /**
     * 删除任意值为e的节点；
     * @param e
     */
    public void removeNode(E e){
        root =  removeNode(root,e);
    }
    private Node removeNode(Node node,E e){
        //此函数的功能是删除任意节点；
        //所以此时应该递归的来判断要删除的是哪个节点，或者说这个节点根本不存在；
        if (node == null){
            //若是找不到要删除的节点就返回null;
            return null;
        }
        if (e.compareTo(node.data) < 0){
            node.leftChild = removeNode(node.leftChild,e);
        }
        if (e.compareTo(node.data) > 0){
            node.rightChild = removeNode(node.rightChild,e);
        }else{
            //此时，如果当前节点就是要删除的节点；
            if (node.leftChild == null){
                //若此时左子树为空，则返回它的右子树
                Node righ = node.rightChild;
                node.rightChild = null;
                size--;
                return righ;
            }
            if (node.rightChild == null){
                //若此时它的右子树为空，则返回它的左子树；
                Node lift = node.leftChild;
                node.leftChild = null;
                size--;
                return lift;
            }else {
                //如果左右子树都不为0的时候：
                //此时应该找到它的前驱或者后继节点
                //它的左子树中的额最大值或者右子树中的最小值；
                Node successor =  getMinNode(node.rightChild);
                //然后删除右子树最小值节点，链接到后继节点的右子树
                successor.rightChild = removeMinNode(node.rightChild);
                //将原左子树链接到后继节点左子树；
                successor.leftChild = node.leftChild;
                node.leftChild = node.rightChild = null;
                return successor;
            }

        }
        return null;
    }
}
