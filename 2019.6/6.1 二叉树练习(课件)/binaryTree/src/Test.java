/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: TODO
 * @date 2019/6/12 15:23
 */
public class Test {
    public static void main(String[] args) {
        BinSearchTree binSearchTree = new BinSearchTree();
        int[] num = new int[]{7,4,10,2,6,9,11,1,3,5};
        for (int i = 0;i < 10;i++){
            binSearchTree.add(num[i]);
        }
        binSearchTree.preOrder();
        System.out.println();
        binSearchTree.inOrder();
        System.out.println();
        binSearchTree.postOrder();
        System.out.println();
        binSearchTree.levleOrder();
    }
}
/*
            7
        4       10
    2      6  9     11
1      3  5
 */
/*
运行结果：

    7 4 2 1 3 6 5 10 9 11
    1 2 3 4 5 6 7 9 10 11
    1 3 2 5 6 4 9 11 10 7
    7 4 10 2 6 9 11 1 3 5
 */