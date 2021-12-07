package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.DriverManager;

//Creates a connection between the application and database.
public class ConnectionManager {

    private static String url = "jdbc:sqlite:studyMate.db";
    private static Connection con;

    public static Connection getConnection() throws Exception {
        con = DriverManager.getConnection(url);
        return con;
    }
}