package Day25.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 操作Emp的类，最终提供给用户使用；
 */
public class EmpAction {
    private Emp emp = new Emp();
    //设置属性
    public void setEmpValue(String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BeanUtil.setBeanValue(this,str);
    }
    //返回设置后的属性
    public Emp getEmp(){
        return this.emp;
    }
}
