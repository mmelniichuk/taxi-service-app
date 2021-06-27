package jdbc.service.impl;

import java.util.List;
import java.util.Optional;
import jdbc.dao.DriverDao;
import jdbc.lib.Inject;
import jdbc.lib.Service;
import jdbc.model.Driver;
import jdbc.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class DriverServiceImpl implements DriverService {
    private static final Logger logger = LogManager.getLogger(DriverServiceImpl.class);
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        logger.info("create method was called. Data to DB was successful added. "
                + "Params: driver={}", driver);
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        logger.info("get method was called. "
                + "Data from DB was successful fetched. Params: id={}", id);
        return driverDao.get(id).get();
    }

    @Override
    public List<Driver> getAll() {
        logger.info("getAll method was called. Data from DB was successful fetched");
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        logger.info("update method was called. Data from DB was successful updated. "
                + "Params: driver={}", driver);
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("delete method was called. "
                + "Data from DB was successful deleted. Params: id={}", id);
        return driverDao.delete(id);
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        logger.info("findByLogin method was called. "
                + "Data from DB was successful fetched. Params: login={}", login);
        return driverDao.findByLogin(login);
    }
}
