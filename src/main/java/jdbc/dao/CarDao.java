package jdbc.dao;

import java.util.List;
import jdbc.model.Car;

public interface CarDao extends GenericDao<Car> {
    List<Car> getAllByDriver(Long driverId);
}
