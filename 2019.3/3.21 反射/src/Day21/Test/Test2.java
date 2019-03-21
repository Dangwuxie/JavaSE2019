package Day21.Test;

import java.util.Date;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<Date> dateClass = Date.class;
        //通过反射取得Date对象
        Date date = dateClass.newInstance();
        System.out.println(date);
    }
}
