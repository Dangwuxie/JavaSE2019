package www.bit.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dangxuchao
 * @Title: JdbcTest5
 * @ProjectName JDBC
 * @Description: 执行DDL语句，
 * DDL：操作表与数据库，比如创建一个表并且插入数据
 * @date 2019/8/3 15:10
 */
public class JdbcTest5 {
    public static void main(String[] args) {
        Connection conn5 = null;
        Statement stmt = null;

        try {
            //1、注册驱动，将Driver类加载进来
            Class.forName("com.mysql.jdbc.Driver");
            //2、取得数据库链接对象Connection
            conn5 = DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
            //3、写sql语句
            String sql = "create table people(id int,name varchar(20),salary double(5,2))";
            //4、获取执行sql语句的对象Statement
            stmt = conn5.createStatement();
            //5、执行语句
            int count = stmt.executeUpdate(sql);

            System.out.println(count);

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
            if (conn5!=null){
                try {
                    conn5.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
