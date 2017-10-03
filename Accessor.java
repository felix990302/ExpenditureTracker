/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import java.sql.*;

/**
 *
 * @author chang
 */
public class Accessor {

    private static Accessor instance = new Accessor();

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/grossexpenditure";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    private Accessor() {
        try {
            Class.forName(JDBC_DRIVER); 
            System.out.println("Connecting to database...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("ERROR: unable to Connect to Database.");
        }

        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}
