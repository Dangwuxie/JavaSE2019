package Day13.Test;
//List接口使用自定义类的对象；

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Person2{
    private String name;
    private Integer age;

    public Person2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "Person{"+"name="+name+","
                +"age="+age+"}";
    }

    @Override
    public boolean equals(Object obj) {
        //判断是否是同一个地址
        if (obj == this){
            return true;
        }else if (obj == null){
            return false;
        }else if (!(obj instanceof Person2)){
            return false;
        }
        //向下转型还原为Person2对象
        Person2 per2 = (Person2) obj;
        return this.age.equals(per2.age)
                && this.name.equals(per2.name);
    }
}
public class Test2 {
    public static void main(String[] args) {
        List<Person2> list = new Vector<>();
        list.add(new Person2("张三",20));
        list.add(new Person2("李四",11));
        list.add(new Person2("五号",33));
        System.out.println(list);
        System.out.println(list.contains(new Person2("张三",20)));
        System.out.println(list.remove(new Person2("五号",33)));
        System.out.println(list.size());
        System.out.println(list);
    }
}
