package dxc.javaConfigTest.service.impl;

import dxc.javaConfigTest.dao.UserDao;
import dxc.javaConfigTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 灵魂编程者
 * @Title: UserServiceNormal
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/19 15:53
 */


public class UserServiceNormal implements UserService {


    private UserDao userDao;

    /*public UserServiceNormal(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        userDao.add();
    }
}
