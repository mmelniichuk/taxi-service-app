package jdbc.service;

import jdbc.lib.exception.AuthenticationException;
import jdbc.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
