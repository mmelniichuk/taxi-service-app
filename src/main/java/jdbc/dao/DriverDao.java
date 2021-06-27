package jdbc.dao;

import java.util.Optional;
import jdbc.model.Driver;

public interface DriverDao extends GenericDao<Driver> {
    Optional<Driver> findByLogin(String login);
}
