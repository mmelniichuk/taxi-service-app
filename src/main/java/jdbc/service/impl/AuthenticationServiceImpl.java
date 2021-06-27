package jdbc.service.impl;

import java.util.Optional;
import jdbc.lib.Inject;
import jdbc.lib.Service;
import jdbc.lib.exception.AuthenticationException;
import jdbc.model.Driver;
import jdbc.service.AuthenticationService;
import jdbc.service.DriverService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverService driverService;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driverOptional = driverService.findByLogin(login);
        if (driverOptional.isPresent() && driverOptional.get().getPassword().equals(password)) {
            return driverOptional.get();
        }
        throw new AuthenticationException("Login or password was incorrect");
    }
}
