public class HighArray {
    private long[] arr4;
    private int nElem;
    public HighArray(int max){
        arr4 = new long[max];
        nElem = 0;
    }
    public boolean find(long searcKey){
        int j;
        for (j = 0;j <nElem;j++){
            if (arr4[j] == searcKey)
                break;
        }
        if (j == nElem)
            return false;
        else
            return true;
    }

    //插入
    public void insert(long value){
        arr4[nElem] = value;
        nElem++;
    }
    //删除
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElem; j++) {
            if (arr4[j] == value)
                break;
        }
        if (j == nElem)
            return false;
        else {
            for (int k = j; k < nElem; k++)
                arr4[k] = arr4[k + 1];
            nElem--;
            return true;
        }
    }
    //查看
    public void display(long value){
        for (int j = 0;j < nElem;j++){
            System.out.print(arr4[j]+" ");
        }
        System.out.println();
    }
}
