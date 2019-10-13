package dxc.JVM.早期编译优化_语法糖.自动拆装箱;

/**
 * @author 灵魂编程者
 * @Title: Deom2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/13 14:31
 */
/*
* 自动装箱的陷阱演示
* */
public class Deom2 {
    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        Long g = 3L;
        Short q = 3;
        System.out.println(c == d);//t
        //大于128，而且没有发生运算，所以就不会自动拆箱；
        System.out.println(e == f);//f

        System.out.println(c == (a+b));//t
        //此处是true的原因就是，a+b之后自动转型成为int型
        //源码会使用instance判断是不是Integer的子类
        //然后向上转型然后调用本类中的方法返回value进行比较；
        System.out.println(c.equals(a+b));//t
        System.out.println(g == (a+b));//t

        //此处是false的原因是，g是Long型
        //它的equals方法首先会判断a+b后的类型是不是与Long包装类是不是继承关系
        //如果是，那么就向上转型之后然后拆箱进行比较
        //如果不是，那么直接返回false；
        System.out.println(g.equals(a+b));//f
        System.out.println(q.equals(a+b));//f
        System.out.println("----------------------------------");
        Integer x = 127;
        Integer y = 127;
        System.out.println(x==y);
        System.out.println(x.equals(y));

        System.out.println("----------------------------------");
        Integer q1 = 256;
        int q2 = 256;
        System.out.println(q1 == q2);

    }
}
