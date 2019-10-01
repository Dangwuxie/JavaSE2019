package www.bit.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Dangxuchao
 * @Title: JdbcTest2
 * @ProjectName JDBC
 * @Description: 添加一条记录
 * insert into account values(属性值1，属性值2.。。。)
 * @date 2019/8/3 11:16
 */
public class JdbcTest2 {
    public static void main(String[] args){
        Statement stmt = null;
        Connection conn2 = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、定义sql语句
            String sql = "insert into account values(3,'李四',2000)";
            //3、获取数据库链接对象
            conn2 =
                    DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
            //4、获取执行sql语句对象Statement
            stmt = conn2.createStatement();
            //5、执行sql语句
            int count2 = stmt.executeUpdate(sql);//此时改变了一行，所以返回值应该是1

            //处理结果
            System.out.println(count2);
            if (count2>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
            //释放资源
            /*
            * 因为不论你添加是否成功，都必须释放资源，
            * 所以释放资源应该放在funally语句块里面执行
            * */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7、先释放Statement,因为是由Connectiond对象获取的
            //伪类避免空指针异常，判断一下
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn2!=null){
                try {
                    conn2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
