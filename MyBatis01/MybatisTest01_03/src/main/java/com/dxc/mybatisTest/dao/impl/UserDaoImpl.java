package com.dxc.mybatisTest.dao.impl;

import com.dxc.mybatisTest.dao.IUserDao;
import com.dxc.mybatisTest.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: UserDaoImpl
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/3 20:06
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll(){
        //1、使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2、使用session执行查询所有方法
        List<User> users = session.selectList(
                "com.dxc.mybatisTest.dao.IUserDao.findAll");
        session.close();
        //3、返回查询结果
        return users;

    }
}
