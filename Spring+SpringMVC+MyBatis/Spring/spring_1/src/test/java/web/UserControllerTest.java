package web;

import dxc.Spring_interface.config.AppConfig;
import dxc.Spring_interface.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 灵魂编程者
 * @Title: UserControllerTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/14 18:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
/*
@ContextConfiguration(classes = AppConfig.class)
*/
@ContextConfiguration("classpath:applicationContext2.xml")
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void add(){
        userController.add();
    }

}
