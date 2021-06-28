package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {
    public static final String URL = "YOUR DATABASE URL";
    public static final String USERNAME = "YOUR USERNAME";
    public static final String PASSWORD = "YOUR PASSWORD";
    public static final String JDBC_DRIVER = "YOUR DRIVER";
    private static final Logger logger = LogManager.getLogger(ConnectionUtil.class);

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        logger.info("getConnection method was called. Connection to DB was successful");
        return DriverManager.getConnection(URL, dbProperties);
    }
}
