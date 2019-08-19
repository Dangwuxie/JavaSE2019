package chatroom.dao;

/**
 * @author Dangxuchao
 * @Title: chatroom.User
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/18 20:23
 */
public class User {
    private Integer id;
    private String username;
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
