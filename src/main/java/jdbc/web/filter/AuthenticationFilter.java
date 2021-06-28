package jdbc.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(AuthenticationFilter.class);
    private static final String DRIVER_ID_PARAMETER = "driver_id";
    private Set<String> allowedUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("init method was called...");
        allowedUrls.add("/login");
        allowedUrls.add("/drivers/add");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter method was called...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Long driverId = (Long) session.getAttribute(DRIVER_ID_PARAMETER);
        if (driverId == null && !allowedUrls.contains(request.getServletPath())) {
            logger.error("user not authenticated.");
            response.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(request, response);
        if (driverId != null) {
            logger.info("user authenticated. Params: user id={} " + driverId);
        }
    }
}
