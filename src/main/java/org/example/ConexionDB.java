package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private final String db;
    private final String url;
    private final String user;
    private final String password;

    public ConexionDB(String db, String user, String password) {
        this.db = db;
        this.user = user;
        this.password = password;
        this.url = "jdbc:mysql://localhost/" + db + "?";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url + "user=" + this.user + "&password=" + this.password);
    }

    public String getDb() {
        return db;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
