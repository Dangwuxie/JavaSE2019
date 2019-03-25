package Day25.Test;


public class Test1 {

    public static void main(String[] args) {
	// write your code here
        String str = "emp.name:sdsdvsdv|emp.job:coder";
        //下面就是设置当前对额字符串给对象属性emp
        //准备一次性设置进去
        EmpAction empAction = new EmpAction();
        empAction.setEmpValue(str);
        //然后调用EmpAction中的方法取出来设置后的对象信息；
        System.out.println(empAction.getEmp());
    }
}
