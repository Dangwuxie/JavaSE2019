package www.bit.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dangxuchao
 * @Title: JdbcTest3
 * @ProjectName JDBC
 * @Description:
 * account表修改
 * @date 2019/8/3 11:56
 */
public class JdbcTest3 {
    public static void main(String[] args) {
        Connection conn3 = null;
        Statement stmt = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取数据库链接对象
            conn3 = DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
            //3、定义sql语句
            String sql = "update account set name='王五',balance=666 where id=3";
            //4、获取执行sql语句的对象
            stmt = conn3.createStatement();
            //5、执行语句
            int count = stmt.executeUpdate(sql);
            if (count>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn3!=null){
                try {
                    conn3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
