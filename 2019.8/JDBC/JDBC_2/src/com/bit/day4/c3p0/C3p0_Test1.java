package com.bit.day4.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dangxuchao
 * @Title: C3p0_Test1
 * @ProjectName JDBC
 * @Description: C3p0演示
 * @date 2019/8/4 17:46
 */
public class C3p0_Test1 {
    public static void main(String[] args) throws SQLException {
        //1、创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2、获取链接对象
        Connection conn = ds.getConnection();
        //3、打印
        System.out.println(conn);
    }
}
