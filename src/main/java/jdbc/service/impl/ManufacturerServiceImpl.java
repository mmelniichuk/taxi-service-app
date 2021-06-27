package jdbc.service.impl;

import java.util.List;
import jdbc.dao.ManufacturerDao;
import jdbc.lib.Inject;
import jdbc.lib.Service;
import jdbc.model.Manufacturer;
import jdbc.service.ManufacturerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Logger logger = LogManager.getLogger(ManufacturerServiceImpl.class);
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        logger.info("create method was called. Data to DB was successful added. "
                + "Params: manufacturer={}", manufacturer);
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        logger.info("get method was called. "
                + "Data from DB was successful fetched. Params: id={}", id);
        return manufacturerDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        logger.info("getAll method was called. Data from DB was successful fetched");
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        logger.info("update method was called. Data from DB was successful updated. "
                + "Params: manufacturer={}", manufacturer);
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("delete method was called. "
                + "Data from DB was successful deleted. Params: id={}", id);
        return manufacturerDao.delete(id);
    }
}
