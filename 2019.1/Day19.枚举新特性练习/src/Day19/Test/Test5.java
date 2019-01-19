package Day19.Test;

class Person{
    private String name;
    public Person(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Person per = new Person("阿斯弗");
        System.out.println(per);

    }
}
