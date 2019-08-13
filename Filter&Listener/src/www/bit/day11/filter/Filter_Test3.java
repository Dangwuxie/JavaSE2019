package www.bit.day11.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 13:48
 */
/*@WebFilter("/*")*/
public class Filter_Test3 implements Filter {
    /**
     * 服务器关闭后，Filter对象被销毁。
     * 如果服务器是正常关闭，则会执行destroy方法；
     */
    public void destroy() {
        System.out.println("销毁-----");
    }

    /**
     * 每一次请求被拦截时，会执行；执行多次；
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter---------");
        chain.doFilter(req, resp);
    }

    /**
     * 服务器启动时。会创建Filter对象，然后调用init方法；只执行一次；
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init初始化");

    }

}
