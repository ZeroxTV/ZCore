package de.zeroxtv.zcore.SQL;

import de.zeroxtv.zcore.ZCore;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by ZeroxTV
 */
public class SQLite {
    private SQLiteDataSource source;
    private Connection connection;
    private String path;

    public void connect(String path) {
        try {
            //plugins/ZShops/ZShops.db
            this.path = path;
            source = new SQLiteDataSource();
            source.setUrl(path);
            connection = source.getConnection();
            ZCore.logger.info("Successfully connected to SQLite Database " + path);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            connection = null;
            ZCore.logger.info("Closed SQLite connection to " + path);
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
}
