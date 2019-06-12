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
        binSearchTree.levleOrder();
    }
}
/*
            7
        4       10
    2      6  9     11
1      3  5
 */