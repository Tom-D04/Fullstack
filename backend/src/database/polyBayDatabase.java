package database;

import java.sql.SQLException;

public class polyBayDatabase extends MySQLDatabase {
    public polyBayDatabase(String host, int port, String databaseName, String user, String password) throws SQLException {
        super(host, port, databaseName, user, password);
    }
}
