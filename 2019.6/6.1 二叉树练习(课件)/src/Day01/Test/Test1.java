package Day01.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dangxuchao
 * @Title: Test1
 * @ProjectName 6.1 二叉树练习(课件)
 * @Description: TODO
 * @date 2019/6/9 16:10
 */
public class Test1 {
    public static void main(String[] args) {
        BinTree<Integer> binTree = new BinSearchTree<>();
        int[] num = new int[]{50,40,60,30,45,70,55,42};
        for (int i = 0;i < num.length;i++){
            binTree.add(num[i]);
        }
        ((BinSearchTree<Integer>) binTree).remove(70);
        binTree.preOrder();

     //   System.out.println(binTree);
        /*List<Integer> list = new ArrayList<>();
        while (binTree.getSize() != 0){
            list.add(binTree.removeMax());
        }
        System.out.println(list);
        System.out.println(binTree.getSize());*/


    }
}
