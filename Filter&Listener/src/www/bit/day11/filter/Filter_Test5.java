package www.bit.day11.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 16:01
 */
//表示浏览器直接请求资源时该过滤器会被直接执行
//@WebFilter(value="/index.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.FORWARD,DispatcherType.REQUEST})
public class Filter_Test5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("Filter_Test5");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
