package chatroom.entity;

/**
 * @author Dangxuchao
 * @Title: MessageFromClient
 * @ProjectName chatroom_websocket
 * @Description:
 * 群聊或者私聊前端发送给后端
 * 发送过来的信息实体类,
 * 我们自己需要获取这个信息详情
 * 群聊:{"msg":"777","type":1}
 * 私聊:{"to":"0-","msg":"33333","type":2}
 * @date 2019/8/20 20:10
 */

public class MessageFromClient {
    //聊天信息
    private String msg;
    //聊天类别：1表示群聊，2表示私聊
    private String type;
    //私聊的对象SessionID
    private String to;

    public String getMsg() {
        return msg;
    }

    public String getType() {
        return type;
    }

    public String getTo() {
        return to;
    }
}
