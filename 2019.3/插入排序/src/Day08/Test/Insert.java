package Day08.Test;

public class Insert {
    public static void sort(int[] data){
        int[] dabs = data;
        int n = dabs.length;
        if (n == 0){
            return;
        }else{
            for (int i = 1;i < dabs.length;i++){
                int value = dabs[i];
                for (int j = i-1;j >= 0;j--){
                    if (dabs[j] < value){
                        dabs[j+1] = value;
                    }else{
                        dabs[j+1] = dabs[j];
                        if (j == 0){
                            dabs[j] = value;
                        }
                    }

                }

            }
        }
    }
    public static void print(int[] data){
        for (int o : data){
            System.out.print(o+"  ");
        }
    }
}
