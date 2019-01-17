//面向过程的算法
package Day16.Arrayapp;
public class ArrayApp {
    public static void main(String[] args){
        long[] arr1 = new long[100];//创建数组
        int nElens = 0;
        int j = 0;
        long searchKey = 0;
        arr1[0] = 77;
        arr1[1] = 99;
        arr1[2] = 44;
        arr1[3] = 55;
        arr1[4] = 22;
        arr1[5] = 88;
        arr1[6] = 11;
        arr1[7] = 00;
        arr1[8] = 66;
        arr1[9] = 33;
        nElens = 10;
        //-----显示所有的元素
        for (j = 0;j < nElens;j++)
            System.out.print(arr1[j]+"、");
        System.out.println();
        //查找66
        searchKey = 66;
        for (j = 0;j < nElens;j++) {
            if (arr1[j] == searchKey)
                break;
        }
        if(j == nElens)
                System.out.println("找不到！！");
            else
                System.out.println("找到了"+searchKey+"是"+j);
        //删除55
        searchKey = 55;
        for (j = 0;j < nElens;j++){
            if (arr1[j] == searchKey)
                break;
        }
        for (int k = j;k < nElens;k++){
            arr1[k] = arr1[k+1];
        }
        nElens--;
        //再次显示所有数字
        for (j = 0;j < nElens;j++)
            System.out.print(arr1[j]+"、");
        System.out.println();
    }
}
