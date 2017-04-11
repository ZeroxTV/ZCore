package de.zeroxtv.zcore.SQL;

import com.mysql.cj.jdbc.MysqlDataSource;
import de.zeroxtv.zcore.ZCore;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by ZeroxTV
 */
public class MySQL {
    private MysqlDataSource source;
    private Connection connection;
    private String ip;

    public void connect(String ip, String username, String password) {
        try {
            source = new MysqlDataSource();
            source.setServerName(ip);
            source.setUser(username);
            source.setPassword(password);
            connection = source.getConnection();
            ZCore.logger.info("Successfully connected to SQLite Database " + ip);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            connection = null;
            ZCore.logger.info("Closed MySQL connection to " + ip);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String command) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(command);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String command) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(command);
            statement.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeArray(ArrayList<String> commands) {
        for (String command : commands) {
            execute(command);
        }
    }

    public void switchDatabase(String name)  {
        try {
            connection.setCatalog(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
