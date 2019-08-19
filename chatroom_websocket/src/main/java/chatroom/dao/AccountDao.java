package chatroom.dao;

import chatroom.utils.BaseDao;

import java.sql.*;

/**
 * @author Dangxuchao
 * @Title: AccountDao
 * @ProjectName chatroom_websocket
 * @Description: 关于用户操作模块的dao层
 * @date 2019/8/18 20:05
 */
public class AccountDao {
    //用户登陆,select
    public User userLogin(String username,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        int r = 0;
        try {
            conn = BaseDao.getConnection();
            String sql = "select * from user where username=? and password=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs = stmt.executeQuery();
            if (rs.next()){
                user = getUserInfo(rs);
                System.out.println("查询成功");
            }else{
                System.out.println("失败");
            }
        } catch (SQLException e) {
            System.out.println("查询用户出错！！");
            e.printStackTrace();
        }finally {
            BaseDao.closeResources(rs,stmt,conn);
        }
        return user;
    }
    //将数据表信息封装到User表中
    public User getUserInfo(ResultSet rs){
        User user = new User();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;
    }

    //用户注册,insert
    public boolean userRegister(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccess = false;
        int i = 0;
        try {
            conn = BaseDao.getConnection();
            String sql = "insert into user (username,password) values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            isSuccess = (stmt.executeUpdate()==1);
        } catch (SQLException e) {
            System.out.println("注册失败!!!!!");
        }finally {
            BaseDao.closeResources(stmt,conn);
        }
        return isSuccess;
    }
}
