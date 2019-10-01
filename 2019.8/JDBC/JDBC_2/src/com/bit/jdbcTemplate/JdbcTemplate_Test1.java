package com.bit.jdbcTemplate;

import com.bit.utils.jdbc_utils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Dangxuchao
 * @Title: JdbcTemplate_Test1
 * @ProjectName JDBC
 * @Description: JdbcTemplate入门练习
 * @date 2019/8/4 23:05
 */
public class JdbcTemplate_Test1 {
    public static void main(String[] args) {
        //1、导入jar包
        //2、创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(jdbc_utils.getDs());
        //3、调用方法
        String sql = "update account set balance = 666 where id = ?";

        int count = template.update(sql,1);
        //会自己释放资源
        System.out.println(count);
    }
}
