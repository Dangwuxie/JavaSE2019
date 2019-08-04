package www.bit.com;

import www.bit.domain.Emp;
import www.bit.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dangxuchao
 * @Title: JdbcTest8
 * @ProjectName JDBC
 * @Description: 工具类的练习
 * @date 2019/8/4 10:21
 */
public class JdbcTest8 {
    public static void main(String[] args) {
        List<Emp> list = new JdbcTest7().findAll();
        for (Emp emp:list){
            System.out.println(emp);
        }
        System.out.println(list.size());
    }
    /*
     * 查询所有emp对象
     * */

    public List<Emp> findAll(){
        Connection conn8 = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
           /* //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取链接
            conn7 = DriverManager.getConnection("jdbc:mysql:///db5","root","123456");*/
            conn8 = JdbcUtils.getConnection();
            //3、创建SQL语句
            String sql = "select * from emp";
            //4、获取执行sql的对象
            stmt = conn8.createStatement();
            //5、执行语句，获取ResultSet集合对象,结果集对象
            rs = stmt.executeQuery(sql);
            //6、遍历结果集，封装对象，装载集合
            list = new ArrayList<>();
            Emp emp = null;
            while (rs.next()){
                //获取数据
                int id = rs.getInt(1);
                String  ename = rs.getString(2);
                int job_id = rs.getInt(3);
                int mgr = rs.getInt(4);
                Date joindate = rs.getDate(5);//此处的Date是sql下的Date类，是util包下Date包的子类，此处可以装载
                double salary = rs.getDouble(6);
                double bonus = rs.getDouble(7);
                int dept_id = rs.getInt(8);
                //创建emp对象并且复制
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,stmt,conn8);
        }

        return list;
    }
}
