package dxc.javaConfigTest.dao.impl;

import dxc.javaConfigTest.dao.UserDao;

/**
 * @author 灵魂编程者
 * @Title: UserDaoNormal
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/19 15:34
 */
public class UserDaoNormal implements UserDao {

    @Override
    public void add() {
        System.out.println("添加用户到数据库中......");
    }

}
