package com.bit.day4.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dangxuchao
 * @Title: C3p0_Test2
 * @ProjectName JDBC
 * @Description: c3p0演示
 * @date 2019/8/4 18:42
 */
public class C3p0_Test2 {
    public static void main(String[] args) throws SQLException {
        //DataSource ds = new ComboPooledDataSource();
        //使用自己的配置
        DataSource ds2 = new ComboPooledDataSource("other_c3p0");
        for (int i = 0;i <=10;i++){
            //此时循环改成8就行了
            Connection sonn2 = ds2.getConnection();
            System.out.println(sonn2+" "+i);

        }

    }
}
