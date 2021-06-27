package jdbc.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.lib.Injector;
import jdbc.model.Driver;
import jdbc.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("jdbc");
    private static final Logger logger = LogManager.getLogger(AddDriverController.class);
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        logger.info("doGet method was called...");
        req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("doPost method was called...");
        String name = req.getParameter("name");
        String licenseNumber = req.getParameter("license_number");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Driver driver = new Driver(name, licenseNumber, login, password);
        driverService.create(driver);
        resp.sendRedirect("/drivers/add");
    }
}
