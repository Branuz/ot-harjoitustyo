package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionManager {
    

    private static String url = "jdbc:sqlite:studyMate.db";
    private static Connection con;

    
    /** Creates a connection between the application and database.
     * @return Connection for the database
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        con = DriverManager.getConnection(url);
        return con;
    }
}