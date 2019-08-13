package www.bit.day11.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 14:10
 */
//@WebFilter("/index.jsp")
//@WebFilter("/user/*")//目录拦截，访问user目录下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp") //后缀名拦截，访问后缀名为jsp的资源时，过滤器会被执行
public class Filter_Test4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter_Test4");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
