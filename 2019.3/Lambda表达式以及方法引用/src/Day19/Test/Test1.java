package Day19.Test;
//1、引用静态方法
interface ISubject<P,R>{
    R seitchPara(P p);
}
public class Test1 {

    public static void main(String[] args) {
	// write your code here
        //valueof方法将任何对象转化成字符串输出；
        ISubject<Integer,String> stringISubject = String ::valueOf;

        //输出括号中的对象的seitchPara等同于String里的静态方法
        System.out.println(stringISubject.seitchPara(10));
    }
}
