package jdbc.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.lib.Injector;
import jdbc.model.Car;
import jdbc.model.Manufacturer;
import jdbc.service.CarService;
import jdbc.service.ManufacturerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("jdbc");
    private static final Logger logger = LogManager.getLogger(AddCarController.class);
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService =
                        (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        logger.info("doGet method was called...");
        req.getRequestDispatcher("/WEB-INF/views/cars/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws IOException, ServletException {
        logger.info("doPost method was called...");
        String model = req.getParameter("model");
        long manufacturerId = Long.parseLong(req.getParameter("manufacturer_id"));
        Manufacturer manufacturer = manufacturerService.get(manufacturerId);
        Car car = new Car(model, manufacturer);
        carService.create(car);
        resp.sendRedirect("/cars/add");
    }
}
