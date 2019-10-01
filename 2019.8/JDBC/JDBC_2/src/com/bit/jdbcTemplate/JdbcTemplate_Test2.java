package com.bit.jdbcTemplate;
import com.bit.domain.Emp;
import com.bit.utils.jdbc_utils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    /*
    * 4、查询id为1的记录，将其封装为map集合
    * */
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        //String sql = "select * from emp where id = ? or id = ?";
        //将字段的值和字段的名称封装成了一个map集合，keu='id',value=1001;
        //注意，这个方法查询的结果集长度只能是1，只能返回一个对象
        Map<String,Object> map = template.queryForMap(sql,1001);
        System.out.println(map);
    }

    /*
    * 5、查询所有记录，将其封装成List集合
    * */
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String,Object>> list = template.queryForList(sql);
        for (Map<String,Object> map:list){
            System.out.println(map);
        }
    }

    /*
    * 	6、查询所有记录，封装成Emp对象的List集合
    * */

    @Test
    public void test6(){
        String sql = "select * from emp";
        //query() : 查询结果，将结果集封装成Javabean对象
        //		    返回的是一个一个的对象
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                //此方法每调用一次就会返回一个对象
                Emp emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setJob_id(rs.getInt("job_id"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setJoindate(rs.getDate("joindate"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setBonus(rs.getDouble("bonus"));
                emp.setDept_id(rs.getInt("dept_id"));

                return emp;
            }
        });

         for (Emp emp:list){
             System.out.println(emp);
         }
    }


    @Test
    public void test6_2(){
        String sql = "select * from emp";
        //query() : 查询结果，将结果集封装成Javabean对象
        //		    返回的是一个一个的对象
        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp:list){
            System.out.println(emp);
        }
    }

    /*
    * 		7、查询总记录数，
    * */

    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);


    }

}
