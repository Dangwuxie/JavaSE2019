package dxc.javaConfigTest.config;

import dxc.javaConfigTest.dao.UserDao;
import dxc.javaConfigTest.dao.impl.UserDaoNormal;
import dxc.javaConfigTest.dao.impl.UserdaoCatch;
import dxc.javaConfigTest.service.UserService;
import dxc.javaConfigTest.service.impl.UserServiceNormal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 灵魂编程者
 * @Title: AppConfig
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/19 15:37
 */

@Configuration
public class AppConfig {


    //此注解作用就是spring启动的时候会自动调用此方法
    @Bean
    @Qualifier("1")
    public UserDao userDaoNormal(){
        System.out.println("返回UserDaoNormal对象......");
        return new UserDaoNormal();
    }

    @Bean

    public UserService userServiceNormal(@Qualifier("2") UserDao userDao){
        System.out.println("自动调用userServiceNormal.....");
        //UserDao userDao = userDaoNormal();
        //return new UserServiceNormal(userDao);
        UserServiceNormal userService = new UserServiceNormal();
        userService.setUserDao(userDao);
        return userService;
    }

    @Bean
    //@Primary
    @Qualifier("2")
    public UserDao userDaoCatch(){
        System.out.println("返回UserDaoCatch对象...");
        return new UserdaoCatch();
    }

}
