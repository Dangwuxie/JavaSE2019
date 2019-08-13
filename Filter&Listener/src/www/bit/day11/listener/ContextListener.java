package www.bit.day11.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Dangxuchao
 * @Title: ContextListener
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 17:34
 */
@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * 监听SrvletContext对象创建的
     * 在服务器启动后自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("这个对象被创建了");
    }

    /**
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
