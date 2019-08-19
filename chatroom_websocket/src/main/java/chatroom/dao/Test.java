package chatroom.dao;
/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/18 22:10
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("ww");
        user.setPassword("123");
        AccountDao accountDao = new AccountDao();
        //int i = accountDao.userRegister(user);
        //System.out.println(i);
        user = accountDao.userLogin("w2w","123");


    }
}
