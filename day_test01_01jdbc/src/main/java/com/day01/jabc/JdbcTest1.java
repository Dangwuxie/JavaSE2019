package com.day01.jabc;

/**
 * @author 灵魂编程者
 * @Title: JdbcTest1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/2 15:10
 */

import java.sql.*;

/**
 * 程序的耦合
 * 耦合：就是程序之间的依赖关系：类之间的依赖、方法之间的依赖
 * 解耦：降低程序之间的依赖关系
 * 实际开发中需要做到b编译器不依赖、运行时才依赖
 * 解决方法：
 *      1、在创建对象的时候使用反射来创建对象，避免使用new来创建对象
 *          好处就是可以减少他们之间的耦合
 *      2、通过读取配置文件来获取要创建的对象全限定类名
 *
 */
public class JdbcTest1 {
    public static void main(String[] args) throws SQLException {
        //1、注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2、获取连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eesy","root","123456");
        //3、获取预编译sql对象
        PreparedStatement pstm =  conn.prepareStatement("select * from account");
        //4、执行sql语句，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5、遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6、释放资源
        rs.close();
        pstm.close();
        conn.close();






    }
}
