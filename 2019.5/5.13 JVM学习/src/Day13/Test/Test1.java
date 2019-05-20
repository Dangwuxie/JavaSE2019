package Day13.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM
 * 两个参数
 * -Xms20M -Xmx20M
 */
class OOMTest{

}
public class Test1 {

    public static void main(String[] args) {
        List<OOMTest> list = new ArrayList<>();
        while (true){
            list.add(new OOMTest());
        }
    }
}
