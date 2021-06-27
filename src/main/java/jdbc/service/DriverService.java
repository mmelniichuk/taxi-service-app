package jdbc.service;

import java.util.Optional;
import jdbc.model.Driver;

public interface DriverService extends GenericService<Driver> {
    Optional<Driver> findByLogin(String login);
}
