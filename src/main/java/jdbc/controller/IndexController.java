package jdbc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.lib.Injector;
import jdbc.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndexController extends HttpServlet {
    private static final String DRIVER_ID_PARAMETER = "driver_id";
    private static final Logger logger = LogManager.getLogger(IndexController.class);
    private static final Injector injector = Injector.getInstance("jdbc");
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("doGet method was called...");
        HttpSession session = req.getSession();
        Long driverId = (Long) session.getAttribute(DRIVER_ID_PARAMETER);
        String name = driverService.get(driverId).getName();
        req.setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
