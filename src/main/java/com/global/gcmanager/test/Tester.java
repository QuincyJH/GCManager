package com.global.gcmanager.test;

import com.global.gcmanager.model.Directory;
import com.global.gcmanager.service.GCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;


public class Tester {

    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/gcm_schema"; //pointing to no database.
        String username = "root";
        String password = "pass";
        System.out.println("Connecting to server...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Server connected!");
            Statement stmt = null;
            ResultSet resultset = null;

            try {
                stmt = connection.createStatement();
                resultset = stmt.executeQuery("SHOW DATABASES;");

                if (stmt.execute("SHOW DATABASES;")) {
                    resultset = stmt.getResultSet();
                }

                while (resultset.next()) {
                    System.out.println(resultset.getString("Database"));
                }
            }
            catch (SQLException ex){
                // handle any errors
                ex.printStackTrace();
            }
            finally {
                // release resources
                if (resultset != null) {
                    try {
                        resultset.close();
                    } catch (SQLException sqlEx) { }
                    resultset = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) { }
                    stmt = null;
                }

                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the server!", e);
        }

    }
}