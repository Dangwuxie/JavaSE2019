package www.bit.day11.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 16:33
 */
@WebFilter("/*")
public class Filter_Test7 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("ServletTest777执行了");
        chain.doFilter(req, resp);
        System.out.println("Test7回来了-------");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
