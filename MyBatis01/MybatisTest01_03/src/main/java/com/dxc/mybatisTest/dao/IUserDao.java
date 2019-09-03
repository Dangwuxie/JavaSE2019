package com.dxc.mybatisTest.dao;

/**
 * @author 灵魂编程者
 * @Title: IUserDao
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/3 0:36
 */

import com.dxc.mybatisTest.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /*
        查询所有操作
     */
    List<User> findAll();

}
