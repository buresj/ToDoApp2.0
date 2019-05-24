package com.todo.app.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("database")
public class DatabaseManager implements StoreService {

    private String database = "book";
    private String dbURL = "jdbc:mysql://localhost:3306/book";
    private String username = "mysqladmin";
    private String password = "";

    private Connection dbCon = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public List<String> load() {

        String query = "SELECT * FROM todo";
        List<String> content = new ArrayList<>();

        try {
            dbCon = DriverManager.getConnection(dbURL, username, password);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                content.add(rs.getString(1) + ", "
                        + rs.getString(2) + ", "
                        + rs.getString(3) + ", "
                        + rs.getString(4) + ", "
                        + rs.getString(5));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return content;
    }

    @Override
    public void save(List<String> task) {

        String query = "INSERT INTO todo VALUES("
                + task.get(0) + ",'" //id
                + task.get(1) + "',NOW(),"  //content
                + task.get(2) + ",'" // days to finish
                + task.get(3) + "')"; // finished

        try {
            dbCon = DriverManager.getConnection(dbURL, username, password);
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void changeStatus(int index) {
        String query = "UPDATE todo finished = 1 WHERE task_id ==" + index;

        try {
            dbCon = DriverManager.getConnection(dbURL, username, password);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM todo WHERE task_id =" + index;

        try {
            dbCon = DriverManager.getConnection(dbURL, username, password);
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
