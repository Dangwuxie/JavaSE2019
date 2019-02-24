package Day23.Test;
//static类属性；
class Person8{
    private static String country;
    private String name;
    private int age;

    public Person8(String name,int age){
        this.age = age;
        this.name = name;
    }
    public static void setCountry(String c){
        country = c;
    }
    public void getPersonInfo(){
        System.out.println("姓名 "+this.name+" 年龄"+this.age+
                "  国籍"+country);
    }
}
public class Test8 {
    public static void main(String[] args) {
        Person8.setCountry("美国");
        Person8 person8 = new Person8("汤姆",666);
        person8.getPersonInfo();
    }
}
