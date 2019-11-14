package dxc.Spring_interface.web;

import dxc.Spring_interface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: UserController
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/14 18:08
 */

@Component
public class UserController {

    @Autowired
    @Qualifier("userServiceNormal")
    private UserService userService;

    public void add(){
        userService.add();
    }

}
