package www.bit.day11.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Filter_Test1
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 11:12
 */
/*@WebFilter("/*")*/
public class Filter_Test1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterTest1被执行了");
        //放行

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
