package dxc.Spring_interface.dao.impl;

import dxc.Spring_interface.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: UserDaoNomal
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/14 18:00
 */


@Component
public class UserDaoNormal implements UserDao {

    @Override
    public void add() {
        System.out.println("添加用户到数据库中.......");
    }
}
