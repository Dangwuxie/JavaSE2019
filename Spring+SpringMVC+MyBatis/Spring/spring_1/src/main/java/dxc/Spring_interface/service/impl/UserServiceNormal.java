package dxc.Spring_interface.service.impl;


import dxc.Spring_interface.dao.UserDao;
import dxc.Spring_interface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: UserServiceNormal
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/13 23:02
 */

@Component()
//@Qualifier("nomal")
public class UserServiceNormal implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        userDao.add();
    }
}




