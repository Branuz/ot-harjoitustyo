package com.poussu.studymate.dataBaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionManager {

    private static String url = "jdbc:sqlite:studyMate.db";
    private static Connection con;

    public static Connection getConnection() throws Exception {
        con = DriverManager.getConnection(url);
        return con;
    }
}