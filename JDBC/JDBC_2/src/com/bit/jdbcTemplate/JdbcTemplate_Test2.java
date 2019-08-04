package com.bit.jdbcTemplate;
import com.bit.utils.jdbc_utils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Dangxuchao
 * @Title: JdbcTemplate_Test2
 * @ProjectName JDBC
 * @Description: TODO
 * @date 2019/8/4 23:30
 */
public class JdbcTemplate_Test2 {
    //将会有七个方法
    //Junit单元测试，可以让方法独立执行

    //获取jdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(jdbc_utils.getDs());

    /*
    * 	1、修改1号数据的salary为10000
    * */
    @Test  //这个注解的意思就是可以独立运行
    public void test1(){
        //定义sql
        String sql = "update emp set salary = 66666 where id = 1001";
        //执行sql
        int count = template.update(sql);
        System.out.println(count);

    }

    /*
    * 2、添加一条记录
    * */
    @Test  //这个注解的意思就是可以独立运行
    public void test2(){
        //定义sql
        String sql = "insert into emp (id,ename,dept_id) values (?,?,?)";//防止sql注入
        //执行sql
        int count = template.update(sql,1030,"牛牛",40);
        System.out.println(count);
    }

    /*
    * 	3、删除刚才添加的记录
    * */
    @Test  //这个注解的意思就是可以独立运行
    public void test3(){
        //定义sql
        String sql = "delete from emp where id=?";//防止sql注入
        //执行sql
        int count = template.update(sql,1030);
        System.out.println(count);

    }

}
