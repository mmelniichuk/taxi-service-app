package jdbc.controller.driver;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.lib.Injector;
import jdbc.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("jdbc");
    private static final Logger logger = LogManager.getLogger(DeleteDriverController.class);
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("doGet method was called...");
        driverService.delete(Long.parseLong(req.getParameter("id")));
        resp.sendRedirect("/drivers/all");
    }
}
