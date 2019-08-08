package www.bit.day8.Test;

import org.junit.Test;
import www.bit.day8.registTest.User;
import www.bit.day8.userdao.Userdao;

/**
 * @author Dangxuchao
 * @Title: UserTest
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/8 15:48
 */
public class UserTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("zhangsan");
        loginuser.setPassword("111111");

        Userdao dao = new Userdao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }

}
