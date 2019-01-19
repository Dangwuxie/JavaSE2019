package Day19.Test;

class Person1{
    private String name;
    @Deprecated
    public Person1(){
        System.out.println("哈哈哈");
    }
    public Person1(String name){
        this.name = name;
        System.out.println("  "+this.name);
    }
    public String toString(){
        return name;
    }
}
public class Test6 {
    public static void main(String[] args) {
        Person1 per = new Person1();
        Person1 PER1 = new Person1("ASD");
    }
}
