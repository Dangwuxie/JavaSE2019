package www.bit.com;

import www.bit.domain.Emp;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dangxuchao
 * @Title: JdbcTest7
 * @ProjectName JDBC
 * @Description: 练习
 * 练习，定义一个方法，查询emp表，并将其封装成对象，装载集合，然后打印：
 * @date 2019/8/3 16:24
 */
public class JdbcTest7 {
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
        Connection conn7 = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取链接
            conn7 = DriverManager.getConnection("jdbc:mysql:///db5","root","123456");
            //3、创建SQL语句
            String sql = "select * from emp";
            //4、获取执行sql的对象
            stmt = conn7.createStatement();
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


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn7!=null){
                try {
                    conn7.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
/*
        运行结果：

"C:\Program Files\Java\jdk1.8.0_131\bin\java.exe" "-javaagent:C:\Java IDEA\IntelliJ IDEA 2018.1.6\lib\idea_rt.jar=3424:C:\Java IDEA\IntelliJ IDEA 2018.1.6\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_131\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_131\jre\lib\rt.jar;D:\Github\JavaSE2019\JDBC\out\production\JDBC_1;D:\Github\JavaSE2019\JDBC\JDBC_1\libs\mysql-connector-java-5.1.37-bin.jar" www.bit.com.JdbcTest7
Emp{id=1001, ename='孙悟空', job_id=4, mgr=1004, joindate=2000-12-17, salary=8000.0, bonus=0.0, dept_id=20}
Emp{id=1002, ename='卢俊义', job_id=3, mgr=1006, joindate=2001-02-20, salary=16000.0, bonus=3000.0, dept_id=30}
Emp{id=1003, ename='林冲', job_id=3, mgr=1006, joindate=2001-02-22, salary=12500.0, bonus=5000.0, dept_id=30}
Emp{id=1004, ename='唐僧', job_id=2, mgr=1009, joindate=2001-04-02, salary=29750.0, bonus=0.0, dept_id=20}
Emp{id=1005, ename='李逵', job_id=4, mgr=1006, joindate=2001-09-28, salary=12500.0, bonus=14000.0, dept_id=30}
Emp{id=1006, ename='宋江', job_id=2, mgr=1009, joindate=2001-05-01, salary=28500.0, bonus=0.0, dept_id=30}
Emp{id=1007, ename='刘备', job_id=2, mgr=1009, joindate=2001-09-01, salary=24500.0, bonus=0.0, dept_id=10}
Emp{id=1008, ename='猪八戒', job_id=4, mgr=1004, joindate=2007-04-19, salary=30000.0, bonus=0.0, dept_id=20}
Emp{id=1009, ename='罗贯中', job_id=1, mgr=0, joindate=2001-11-17, salary=50000.0, bonus=0.0, dept_id=10}
Emp{id=1010, ename='吴用', job_id=3, mgr=1006, joindate=2001-09-08, salary=15000.0, bonus=0.0, dept_id=30}
Emp{id=1011, ename='沙僧', job_id=4, mgr=1004, joindate=2007-05-23, salary=11000.0, bonus=0.0, dept_id=20}
Emp{id=1012, ename='李逵', job_id=4, mgr=1006, joindate=2001-12-03, salary=9500.0, bonus=0.0, dept_id=30}
Emp{id=1013, ename='小白龙', job_id=4, mgr=1004, joindate=2001-12-03, salary=30000.0, bonus=0.0, dept_id=20}
Emp{id=1014, ename='关羽', job_id=4, mgr=1007, joindate=2002-01-23, salary=13000.0, bonus=0.0, dept_id=10}
14

Process finished with exit code 0
* */