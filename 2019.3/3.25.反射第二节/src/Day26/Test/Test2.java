package Day26.Test;
//动态代理；

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//真实业务接口
interface ISubject {
    void eat(String name,int count);
}
//真实业务类
class RealSubject implements ISubject{
    @Override
    public void eat(String name, int count) {
        System.out.println("吃"+count+"两"+name);
    }
}

//代理类，不能绑定固定的接口，不能实现具体接口
//因为要实现若干个接口；
class ProxySubject implements InvocationHandler{
    private Object object;
    /**
     * 将真实接口与代理类绑定；
     * @return  返回绑定好的代理类对象；
     */
    public Object bind(Object realObject){
        this.object = realObject;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
    /**
     *invoke是接口里的方法，需要覆写；
     * @param proxy 代理类对象；
     * @param method 真实类的方法；
     * @param args 真实方法的参数；
     * @return 返回一个真实接口的对象；
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object obj = method.invoke(this.object,args);
        this.after();
        return obj;
    }
    public void before(){
        System.out.println("吃饭前");
    }
    public void after(){
        System.out.println("吃饭后");
    }
}


public class Test2 {
    public static void main(String[] args) {
        ISubject iSubject = (ISubject) new ProxySubject().bind(new RealSubject());
        iSubject.eat("撒擦擦撒擦擦",5);
    }
}
