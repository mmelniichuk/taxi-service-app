package jdbc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.lib.Injector;
import jdbc.lib.exception.AuthenticationException;
import jdbc.model.Driver;
import jdbc.service.AuthenticationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final String DRIVER_ID_PARAMETER = "driver_id";
    private static final Injector injector = Injector.getInstance("jdbc");
    private static final Logger logger = LogManager.getLogger(LoginController.class);
    private final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        logger.info("doGet method was called...");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Driver driver = authenticationService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute(DRIVER_ID_PARAMETER, driver.getId());
            logger.info("login was successful.");
            resp.sendRedirect("/index");
        } catch (AuthenticationException e) {
            logger.error("cannot login.", e);
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
