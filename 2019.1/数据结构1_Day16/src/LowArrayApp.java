public class LowArrayApp {
    public static void main(String[] args){
        LowArray arr3;
        arr3 = new LowArray(100);
        int nElem = 0;
        int j = 0;
        long searchkey = 66;
        arr3.setElement(0,77);
        arr3.setElement(1,99);
        arr3.setElement(2,44);
        arr3.setElement(3,55);
        arr3.setElement(4,22);
        arr3.setElement(5,88);
        arr3.setElement(6,11);
        arr3.setElement(7,00);
        arr3.setElement(8,66);
        arr3.setElement(9,33);
        nElem = 10;
        //显示所有元素
        for (j = 0;j <nElem;j++){
            System.out.print(arr3.getElement(j)+".");
        }
        System.out.println();
        //查找66
        for (j = 0;j < nElem;j++){
            if (arr3.getElement(j) == searchkey)
                break;
        }
        if (j == nElem){
            System.out.println("没找到"+searchkey);
        }else{
            System.out.println("找到了"+searchkey+"索引号"+j);
        }
        //删除55
        searchkey = 55;
        for (j = 0;j < nElem;j++){
            if (arr3.getElement(j) == searchkey){
                break;
            }
        }
        for (int p = j;p < nElem;p++){
            arr3.setElement(p,arr3.getElement(p+1));
        }
        nElem--;
        //显示所有元素
        for (j = 0;j <nElem;j++){
            System.out.print(arr3.getElement(j)+".");
        }
    }
}
