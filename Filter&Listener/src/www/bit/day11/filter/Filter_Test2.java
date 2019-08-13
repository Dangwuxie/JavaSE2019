package www.bit.day11.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 12:17
 */
/*@WebFilter("/*")*/
public class Filter_Test2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象的请求消息做一个增强
        System.out.println("filterTest开始了");
        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("filterTest2huilail来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
