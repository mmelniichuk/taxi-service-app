package jdbc.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.lib.Injector;
import jdbc.model.Car;
import jdbc.model.Driver;
import jdbc.service.CarService;
import jdbc.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddDriverToCarController extends HttpServlet {
    private static final String DRIVER_ID_PARAMETER = "driver_id";
    private static final Injector injector = Injector.getInstance("jdbc");
    private static final Logger logger = LogManager.getLogger(AddDriverToCarController.class);
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService =
                                    (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        logger.info("doGet method was called...");
        req.getRequestDispatcher("/WEB-INF/views/cars/drivers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws IOException {
        logger.info("doPost method was called...");
        long driverId = Long.parseLong(req.getParameter(DRIVER_ID_PARAMETER));
        long carId = Long.parseLong(req.getParameter("car_id"));
        Driver driver = driverService.get(driverId);
        Car car = carService.get(carId);
        carService.addDriverToCar(driver, car);
        resp.sendRedirect("/cars/drivers/add");
    }
}
