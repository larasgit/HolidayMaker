package com.company;
import java.sql.*;

public class DataService {
    private PreparedStatement statement;
    private Connection connect = null;
    private ResultSet resultSet;

    public DataService() throws SQLException {
        connect();
        new Menu(statement, connect, resultSet);
    }

    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:HolidayMaker.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
