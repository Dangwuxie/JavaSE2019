package chatroom.service;

import chatroom.entity.Message2Cilent;
import chatroom.entity.MessageFromClient;
import chatroom.utils.CommUtils;

import javax.servlet.annotation.WebServlet;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

    //需要缓存所有的用户列表,map保存sessionID，username；
    private static Map<String,String> names = new ConcurrentHashMap<>();
    //绑定当前websocket会话
    private Session session;

    //保存一下当前客户端的用户名
    private String userName;

    //第一次跟浏览器建立联机的时候调用此方法
    @OnOpen
    public void onOpen(Session session){
        //绑定传进来的session
        this.session = session;
        //前端传来的username,利用session的方法获取用户名
        //获取的内容：username=' + '${username}'，
        //直接查分字符串就行,取得第二个参数，下标为1；
        String userName = session.getQueryString().split("=")[1];
        this.userName = userName;

        //下面将客户端聊天实体保存到client实体里面
        //添加当前链接到服务器的websocket
        clients.add(this);

        //下面将当前用户以及SessionID保存到用户列表
        names.put(session.getId(),userName);

        //发送给所有用户一个上线的信息，先设置要发送的信息对象Message2Cilent
        Message2Cilent message2Cilent = new Message2Cilent();
        message2Cilent.setContent(userName+"上线了！"+"，Sessionid为："
                +session.getId()+",当前人数："+clients.size()+"人");
        message2Cilent.setNames(names);
        //最终发送给前端的是一个json字符串信息;
        String jsonStr = CommUtils.object2Json(message2Cilent);
        //给所有的当前用户对象都要发送一下
        for (WebSocket webSocket:clients){
            webSocket.sendMessage(jsonStr);
        }

    }
    @OnError
    public void onError(Throwable e){
        System.out.println("连接失败！");
        e.printStackTrace();
    }

    /*通过此类获得群聊或者私聊的信息
    * 就是从客户端端获取的消息
    * */
    @OnMessage
    public void onMessage(String msg){
        /*
          收到的信息类型就是这样的：
        * 群聊:{"msg":"777","type":1}
          私聊:{"to":"0-","msg":"33333","type":2}
        * */

        //首先要将客户端发送过来的信息反序列化
        MessageFromClient messageFromClient =
                (MessageFromClient) CommUtils.json2Object(msg,MessageFromClient.class);
        //取得之后，要判断是私聊信息还是群聊信息
        if (messageFromClient.getType().equals("1")){
            //此时按照规定就是群聊，type是1的话是群聊
            String content = messageFromClient.getMsg();

            //下面转发给所有前端链接
            Message2Cilent message2Cilent = new Message2Cilent();
            message2Cilent.setContent(content);
            message2Cilent.setNames(names);

            //群聊发送就行
            for (WebSocket webSocket:clients){
                //发送的是gson对象
                webSocket.sendMessage(CommUtils.object2Json(message2Cilent));
            }

        }else if (messageFromClient.getType().equals("2")){
            //否则就是私聊
            //获取信息内容
            String content = messageFromClient.getMsg();
            //私聊:{"to":"0-","msg":"33333","type":2}
            //下面要获取私聊的对象是谁
            int len = messageFromClient.getTo().length();
            String tos[] = messageFromClient.getTo().substring(0,len-1).split("-");
            //然后按照“-”拆分就行
            //下面给指定的sessionID发送信息
            //必须判断一下当前的sessionID不是自己的SessionID
            List<String> list = Arrays.asList(tos);//变成集合还可以判断
            for (WebSocket webSocket:clients){
                if (list.contains(webSocket.session.getId()) &&
                        this.session.getId()!= webSocket.session.getId()){
                    //此时需要发送私聊信息
                    Message2Cilent message2Cilent = new Message2Cilent();
                    message2Cilent.setContent(userName,content);
                    message2Cilent.setNames(names);
                    webSocket.sendMessage(CommUtils.object2Json(message2Cilent));
                }
            }

        }
    }
    @OnClose
    public void close(){
        //移除当前链接到服务器的websocket
        clients.remove(this);

        //下面将当前用户以及SessionID从用户列表删除
        names.put(session.getId(),userName);

        //发送给所有用户一个上线的信息，先设置要发送的信息对象Message2Cilent
        Message2Cilent message2Cilent = new Message2Cilent();
        message2Cilent.setContent(userName+"离开了！"+"，Sessionid为："
                +session.getId()+",当前人数："+clients.size()+"人");
        message2Cilent.setNames(names);

        //最终发送给前端的是一个json字符串信息;
        //将信息对象Message2Cilent转化成json对象
        String jsonStr = CommUtils.object2Json(message2Cilent);
        //给所有的当前用户对象都要发送一下
        for (WebSocket webSocket:clients){
            webSocket.sendMessage(jsonStr);
        }
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
