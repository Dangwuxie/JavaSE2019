package dxc.Spring_interface.config;

import dxc.Spring_interface.dao.UserDao;
import dxc.Spring_interface.service.UserService;
import dxc.Spring_interface.web.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 灵魂编程者
 * @Title: AppConfig
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/13 23:05
 */

@Configuration
//以当前的包作为基础来扫描当前包里面的所有组件；
//@ComponentScan("dxc.Spring_interface")
/*@ComponentScan(basePackages =
        {"dxc.Spring_interface.dao",
                "dxc.Spring_interface.service",
                "dxc.Spring_interface.web"})*/
/*@ComponentScan(basePackageClasses =
        {*//*类名*//*UserController.class,
                UserService.class,
                UserDao.class})*/
public class AppConfig {

}
