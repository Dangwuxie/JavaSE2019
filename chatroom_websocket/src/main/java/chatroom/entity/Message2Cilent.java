package chatroom.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author Dangxuchao
 * @Title: MessageToCilent
 * @ProjectName chatroom_websocket
 * @Description: 后端发送给前端的信息实体
 * @date 2019/8/20 20:15
 */
@Data
public class Message2Cilent {
    //聊天内容
    private String content;
    //服务端登陆的所有用户列表,服务端给前端发送的
    private Map<String,String> names;

    public void setContent(String content) {
        this.content = content;
    }
    public void setContent(String userName,String content) {
        this.content = userName+"说："+content;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }
}
