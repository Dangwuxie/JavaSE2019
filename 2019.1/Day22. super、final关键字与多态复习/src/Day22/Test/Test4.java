package Day22.Test;
//调用普通方法
class Dog{
    public String info = "taidi";
    public void print(){
        System.out.println("1.Dog");
    }
}
class Erha extends Dog{
    public void print(){
        super.print();
        System.out.println(super.info);
    }
}
public class Test4 {
    public static void main(String[] args) {
        Erha erha = new Erha();
        erha.print();
    }
}
