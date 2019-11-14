package service;

import dxc.Spring_interface.config.AppConfig;
import dxc.Spring_interface.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author 灵魂编程者
 * @Title: UserServiceTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/13 23:42
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {

    /*@Autowired
    @Qualifier("nomal")*/
    @Resource(name = "ff")
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }

}













