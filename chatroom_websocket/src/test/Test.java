import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/19 15:32
 */
class Person3{
    int num = 1;
    public Person3(){
        System.out.println(this.num);
        this.print();
        num = 2;
    }
    public void print(){
        System.out.println("Person:"+num);
    }
}
class Sub extends Person3{
    int num = 3;

    public Sub() {
        this.print();
        num = 4;
    }

    public void print(){
        System.out.println("Test:"+num);
    }

}
public class Test {

    public static void main(String[] args) {
        Person3 p = new Sub();
        System.out.println(p.num);
        p.print();
    }
}
