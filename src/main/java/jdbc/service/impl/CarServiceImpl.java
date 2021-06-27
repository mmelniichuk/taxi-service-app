package jdbc.service.impl;

import java.util.List;
import jdbc.dao.CarDao;
import jdbc.lib.Inject;
import jdbc.lib.Service;
import jdbc.model.Car;
import jdbc.model.Driver;
import jdbc.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);
    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.getDrivers().add(driver);
        carDao.update(car);
        logger.info("data to DB was successful added. "
                + "Params: car={}, driver={}", car, driver);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDrivers().remove(driver);
        carDao.update(car);
        logger.info("data from DB was successful removed. "
                + "Params: car={}, driver={}", car, driver);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        logger.info("data from DB was successful fetched. Params: driver id={}", driverId);
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        logger.info("create method was called. Data to DB was successful added. "
                + "Params: car={}", car);
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        logger.info("get method was called. "
                + "Data from DB was successful fetched. Params: id={}", id);
        return carDao.get(id).get();
    }

    @Override
    public List<Car> getAll() {
        logger.info("getAll method was called. Data from DB was successful fetched");
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        logger.info("update method was called. Data from DB was successful updated. "
                + "Params: car={}", car);
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("delete method was called. "
                + "Data from DB was successful deleted. Params: id={}", id);
        return carDao.delete(id);
    }
}
