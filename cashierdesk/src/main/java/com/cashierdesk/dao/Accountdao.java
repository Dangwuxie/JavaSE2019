package com.cashierdesk.dao;

import com.cashierdesk.common.AccountStatus;
import com.cashierdesk.common.AccountType;
import com.cashierdesk.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

/**
 * @author 灵魂编程者
 * @Title: Accountdao
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/22 23:53
 */
public class Accountdao extends BaseDao {
    //操作数据库
    public Account login(String username,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //如果查询成功会返回一个集合，解析resultset集合里面的数据
        //需要变成一个Account对象进行返回
        Account account = null;
        /*接下来就是操作数据库了*/

        try{
            connection = this.getConnection(true);
            String sql = "select id,username,password,name,account_type,account_status from account where username=? and password=?";
            //下来操作数据库
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,DigestUtils.md5Hex(password));
            resultSet = preparedStatement.executeQuery();

            //下面需要将这个结果集组装成一个Account
            if (resultSet.next()){
                //解析result,拿到对应的Account
               return this.extractAccount(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    private Account extractAccount(ResultSet resultSet) throws SQLException {
        //解析resultset
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        account.setName(resultSet.getString("name"));

        account.setAccountType(AccountType.valueOf(resultSet.getInt("account_type")));
        account.setAccountStatus(AccountStatus.valueOf(resultSet.getInt("account_status")));

        return account;
    }

    public boolean register(Account account){
        //注册这个account，连接数据库，
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean effect = false;
        try{
            //true代表自动提交事务
            connection = this.getConnection(true);
            String sql = "insert into account(username,password,name," +
                    "account_type,account_status) values(?,?,?,?,?)";
            //Statement.RETURN_GENERATED_KEYS可以获取插入这条语句的自增值
            preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,DigestUtils.md5Hex(account.getPassword()));
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getAccountType().getFlg());
            preparedStatement.setInt(5,account.getAccountStatus().getFlg());

            effect = (preparedStatement.executeUpdate() == 1);
            //getGeneratedKeys():获取自增的主键
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                //插入成功
                Integer id = resultSet.getInt(1);
                //这里有个问题，要是不设置的话那么这个账户就没有id了吗？
                account.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet,preparedStatement,connection);
        }
        return effect;
    }
}
