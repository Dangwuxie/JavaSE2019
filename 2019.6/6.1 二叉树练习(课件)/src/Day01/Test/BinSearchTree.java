package Day01.Test;


/**
 * 二叉搜索树
 */


public class BinSearchTree<E extends Comparable<E>>implements BinTree<E>{

    public BinSearchTree() {
        super();
    }


    /**
     * 先定义一下二叉树中的节点
     * @param
     */

    private class Node{
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * 根节点
     * @param o
     */

    private Node root;

    /**
     * 二叉树节点个数
     * @param o
     */
    private int size;

    @Override
    public void add(E e) {
        /*if (root == null){
            Node node = new Node(e);
            root = node;
            size++;
        }*/
        //否则需要递归地寻找插入位置
        //什么时候停呢，右子树为空的时候
        //因为二分搜索树不包含重复元素，所以如果传入相同元素，
        //就直接return
        root = add(root,e);
    }
    /**
     * 以当前node作为根节点，插入元素为e的节点；
     * 返回插入后的树的根节点；
     * @return
     */
    private Node add(Node node,E e){
        if (node == null){
            Node newNode = new Node(e);
            size++;
            return newNode;
        }
        if (e.compareTo(node.data) < 0){
            node.left = add(node.left,e);
        }
        if (e.compareTo(node.data) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 定义一个递归函数
     * 以指定的节点为根节点，插入指定元素e；
     * @return
     */
    /*private void add(Node node,E e){
        //首先判断当前的node的data根插入的值是重复元素
        //就直接return
        if (node.data.compareTo(e) == 0){
            return;
        }
        else if(e.compareTo(node.data) < 0 && node.left == null){
            Node newNode = new Node(e);
            node.left = newNode;
            size++;
        }
        else if(e.compareTo(node.data) > 0 && node.right == null){
            Node newNode = new Node(e);
            node.right = newNode;
            size++;
        }
        else if (e.compareTo(node.data) < 0){
            //继续递归寻找左子树最终的插入位置吧
            add(node.left,e);
        }
        else if (e.compareTo(node.data) > 0){
            //递归寻找右子树最终位置
            add(node.right,e);
        }
    }*/


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(E e) {
        if (root == null){
            return false;
        }
        //否则以根节点开始递归的查找元素
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if (node.data.compareTo(e) == 0){
            //如果刚好到鞥带与当前节点的值
            return true;
        }
        if (root == null){
            return false;
        }
        else if (e.compareTo(node.data) < 0){
            return contains(node.left,e);
        }
        else{
            return contains(node.right,e);
        }

    }

    /**
     * 前序遍历
     * 以当前节点作为根节点进行前序遍历；
     */

    @Override
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    /**
     * 按照自然的方式输出二叉树
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateTreeStruct(root,0,res);
        return res.toString();
    }

    /**
     *
     * @param node 头节点
     * @param depth 层数
     * @param res 输出的方式
     */
    private void generateTreeStruct(Node node,int depth,StringBuilder res){
        //如果此时节点为空，输出null加个换行符
        if (node == null){
            res.append("null"+"\n");
            return;
        }
        //如果不为空
        //在输出值之前先打印两道杠
        //根据层数的不同来决定杠的个数
        res.append(generateGang(depth)+node.data+"\n");
        generateTreeStruct(node.left,depth+1,res);
        generateTreeStruct(node.right,depth+1,res);
    }
    private String generateGang(int depth){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < depth;i++){
            sb.append("--");
        }
        return sb.toString();
    }
    /**
     * 中序遍历
     * @param node
     */
    @Override
    public void inOrder() {
       inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        preOrder(node.left);
        System.out.println(node.data);
        preOrder(node.right);
    }
    /**
     * 后序遍历
     * @param node
     */
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    @Override
    public void levelOrder() {

    }

    @Override
    public E getMin() {
        return getMinNode(root).data;
    }

    private Node getMinNode(Node node){
        if (node.left == null){
            return node;
        }
        return getMinNode(node.left);
    }

    @Override
    public E getMax() {
        return getMaxNode(root).data;
    }

    private Node getMaxNode(Node node){
        if (node.right == null){
            return node;
        }
        return getMaxNode(node.right);
    }

    @Override
    public E removeMin() {
        return  null;
    }

    @Override
    public E removeMax() {
        return null;
    }

    public Node remove(Node node,E e){
        if (node == null){
            return null;
        }
        if (e.compareTo(node.data) < 0){
            node.left = remove(node.left,e);
        }
        return node;
    }
    public Node removeMaxNode(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;

        }
        return node;
    }

    public static void main(String[] args) {
        BinTree<Integer> binTree = new BinSearchTree<>();
        int[] num = new int[]{28,16,13,22,30,29,42};
        for (int i = 0;i < num.length;i++){
            binTree.add(num[i]);
        }
        //binTree.preOrder();
        //System.out.println();
        System.out.println(binTree);
    }

}
/*
    运行结果：

    28
    --16
    ----13
    null
    null
    ----22
    null
    null
    --30
    ----29
    null
    null
    ----42
    null
    null

 */