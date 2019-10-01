package com.bit.day4.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Dangxuchao
 * @Title: Druid_Test1
 * @ProjectName JDBC
 * @Description: druid演示
 * @date 2019/8/4 19:07
 */
public class Druid_Test1 {
    public static void main(String[] args) throws Exception {
        //导入jar包已经完成
        //2、定义配置文件

        //3、加载配置文件
        Properties pro = new Properties();
        InputStream is =  Druid_Test1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4、获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5、获取练级额
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
