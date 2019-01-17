public class LowArray {
    private long[] arr2;
    //构造函数；
    public LowArray(int size){
        arr2 = new long[size];
    }
    public void setElement(int index,long value){
        arr2[index] = value;
    }
    public long getElement(int index){
        return arr2[index];
    }
}
