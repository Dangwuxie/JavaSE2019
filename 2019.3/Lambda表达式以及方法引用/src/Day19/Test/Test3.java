package Day19.Test;
//引用某个类的普通方法
@FunctionalInterface
interface Person3<P,R>{
    P switchPara(R r,R r2);
}
public class Test3 {
    public static void main(String[] args) {
        Person3<Integer,String> person3 = String ::compareTo;
        System.out.println(person3.switchPara("A","O"));
    }
}
