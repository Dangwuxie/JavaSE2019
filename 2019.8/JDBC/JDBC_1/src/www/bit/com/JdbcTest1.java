package www.bit.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dangxuchao
 * @Title: JdbcTest1
 * @ProjectName JDBC
 * @Description: 快速入门
 * @date 2019/8/3 9:44
 */
public class JdbcTest1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、第一步，导入驱动jar包
        //2、注册驱动,把这个类加载进来
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库的连接对象
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db4","root","123456");
        //4、定义sql语句
       // String sql = "update account set balance=500 where id=1";
        String sql = "update account set balance=500";//此时影响的行数是2；返回值就是2；

        //5、获取执行sql的对象Statement
        Statement stmt = connection.createStatement();
        //6、执行sql
        int count = stmt.executeUpdate(sql);
        //7、处理结果
        System.out.println(count);
        //释放资源
        stmt.close();;
        connection.close();
    }
}
