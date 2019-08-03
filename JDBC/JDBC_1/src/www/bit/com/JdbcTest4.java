package www.bit.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dangxuchao
 * @Title: JdbcTest4
 * @ProjectName JDBC
 * @Description: 删除表中的一条记录
 * @date 2019/8/3 12:25
 */
public class JdbcTest4 {
    public static void main(String[] args) {
        Connection conn4 = null;
        Statement stmt = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取数据库链接对象
            conn4 = DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
            //3、定义sql语句
            String sql = "delete from account where id=2";
            //4、获取Statement对象执行sql语句
            stmt = conn4.createStatement();
            //5、执行
            int count = stmt.executeUpdate(sql);
            //6、判断
            if (count > 0){
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
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
            if (conn4!=null){
                try {
                    conn4.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
