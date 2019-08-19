package chatroom.config;

import freemarker.template.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Dangxuchao
 * @Title: FreeMarkerListener
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/19 23:05
 */
//加注解以后表示这个类具备了监听器的能力
@WebListener
public class FreeMarkerListener implements ServletContextListener {
    public static final String TEMPLATE_KEY = "_template_";
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //配置Configuration的版本
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        //配置加载ftl的路径
        try {
            cfg.setDirectoryForTemplateLoading(new File(
                    "D:\\Github\\JavaSE2019\\chatroom_websocket\\src\\main\\webapp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //配置页面的编码,跟前端的页面保持一致
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.displayName());

        //然后把整个的配置写入上下文中
        sce.getServletContext().setAttribute(TEMPLATE_KEY,cfg);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
