package Day25.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 操作简单类属性设置的工具类；
 *
 */
public class BeanUtil {
    private BeanUtil(){}

    /**
     *
     * @param action 拿到提供给用户使用的xxAction类
     * @param beanValue 要设置的具体值；
     *
     */
    public static void setBeanValue(Object actionObj,String beanValue) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //"emp.name:sdsdvsdv|emp.job:coder"
        String[] temp = beanValue.split("\\|");

        for (int i = 0;i <temp.length;i++){
            //拆分出属性名称、类名称、值
            //emp.name:sdsdvsdv
            String[] result = temp[i].split(":");
            //emp.name
            //sdsdvsdv
            String realValue = result[1];
            //emp.name
            String className = result[0].split("\\.")[0];
            String attrName = result[0].split("\\.")[1];
            //根据xxAction类取得真正操作的主题类Emp;
            //通过反射调用getEmp()
            Object realObj = getRealObject(actionObj,className);
            System.out.println(realObj);
        }
    }

    /**
     * 类的内部使用了一个小方法；
     * 取得真正操作的对象
     * @param actionObj 就是xxAcyion；
     * @param className 要操作的类名称
     * @return
     */
    private static Object getRealObject(Object actionObj,
                                String className) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.取得xxAction Class对象
        Class<?> cls = actionObj.getClass();
        //2.拼装getXX()方法名称
        String methodName = "get"+initCap(className);
        //3.取得该方法名称的Method对象，最终要操作它
        Method method = cls.getMethod(methodName);
        //4.通过反射调用该方法；
        //等同于empAction.getEmp();
        return method.invoke(actionObj);

    }
    private static String initCap(String str){
        return str.substring(0,1).toUpperCase()
                +str.substring(1);
    }
}
