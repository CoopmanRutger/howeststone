package field.api.intialize.SQLcontoller;

import java.sql.*;

public class SqlDatabase {

    private final String url;
    private final String user;
    private final String password;

    public SqlDatabase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load database driver, shutting down ...");
            System.exit(-1);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
