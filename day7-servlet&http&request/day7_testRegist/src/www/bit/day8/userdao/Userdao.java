package www.bit.day8.userdao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import www.bit.day8.JDBCutils.JDBCutils;
import www.bit.day8.registTest.User;

/**
 * @author Dangxuchao
 * @Title: Userdao
 * @ProjectName day7-servlet&http&request
 * @Description: 操作user表的类
 * @date 2019/8/8 15:22
 */
public class Userdao {
    //生命一个成员变量JDBCTemplate公用
    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());


    /**
     *
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据
     */
    public User login(User loginUser){
        try {
            //编写sql
            String sql = "select * from user where name=? and password=?";
            //调用jquery方法
            User user = template.queryForObject(
                    sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
