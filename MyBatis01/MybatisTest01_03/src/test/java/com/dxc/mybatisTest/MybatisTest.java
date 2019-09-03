package com.dxc.mybatisTest;

import com.dxc.mybatisTest.dao.IUserDao;
import com.dxc.mybatisTest.dao.impl.UserDaoImpl;
import com.dxc.mybatisTest.domain.User;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: MybatisTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/3 10:48
 */
public class MybatisTest {
    /*
        入门案例
     */
    public static void main(String[] args) throws IOException {
        //1、读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3、使用dao工厂创建到的对象，
        IUserDao userDao = new UserDaoImpl(factory);

        //5、使用使用代理对象咨询执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //6、释放资源
        in.close();

    }
}
