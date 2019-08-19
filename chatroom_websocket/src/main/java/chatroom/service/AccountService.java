package chatroom.service;

import chatroom.dao.AccountDao;
import chatroom.dao.User;

/**
 * @author Dangxuchao
 * @Title: AccountService
 * @ProjectName chatroom_websocket
 * @Description:
 * @date 2019/8/18 22:59
 */
public class AccountService {
    AccountDao accountDao = new AccountDao();
    //此方法用来调用AccountDao的两个方法，取得结果
    //1、登陆验证
    public boolean userLogin(String username,String password){
        User user = accountDao.userLogin(username,password);
        if (user == null){
            return false;
        }
        return true;
    }

    //2、验证注册
    public boolean userRegister(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return accountDao.userRegister(user);
    }
}
