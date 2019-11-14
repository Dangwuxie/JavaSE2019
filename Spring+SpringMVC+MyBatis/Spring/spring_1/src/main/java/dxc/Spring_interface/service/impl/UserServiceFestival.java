package dxc.Spring_interface.service.impl;

import dxc.Spring_interface.dao.UserDao;
import dxc.Spring_interface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: UserServiceFestival
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/14 17:17
 */

@Component()
/*@Primary*/
//@Qualifier("festival")
public class UserServiceFestival implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        userDao.add();
    }

}
