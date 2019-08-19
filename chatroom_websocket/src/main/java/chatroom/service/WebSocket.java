package chatroom.service;

import javax.servlet.annotation.WebServlet;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Dangxuchao
 * @Title: WebSocket
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/19 21:13
 */
@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有链接到后端的websocket信息，连几个算几个
    //CopyOnWriteArraySet是一个线程安全的集合,存储当前的websocket
    //定义为静态的，是为了共享数据，每个新的窗口都能看到此数据
    private static CopyOnWriteArraySet<WebSocket> clients =
            new CopyOnWriteArraySet<>();
    //绑定当前websocket会话
    private Session session;

    //第一次跟浏览器建立联机的时候调用此方法
    @OnOpen
    public void onOpen(Session session){
        //绑定传进来的session
        this.session = session;
        //添加当前链接起来的websocket
        clients.add(this);
        System.out.println("有新的链接，当前Sessionid为："
                +session.getId()+",当前人数："+clients.size()+"人");

    }
    @OnError
    public void onError(Throwable e){
        System.out.println("链接失败！");
        e.printStackTrace();
    }
    @OnMessage
    public void onMessage(String msg){
        System.out.println("浏览器发送来的消息为："+msg);
        //群聊，下面要给所有的websocket发送信息
        for (WebSocket webSocket:clients){
            webSocket.sendMessage(msg);
        }
    }
    @OnClose
    public void close(){
        System.out.println("用户退出链接，当前人数："+clients.size()+"人");
        clients.remove(this);
    }

    public void sendMessage(String msg){
        //把信息推送给浏览器
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
