package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poussu.studymate.userdata.User;

public class UserManager {

    //Used for adding a new user in the database.
    public User getLoggedUser(String name, String password) throws SQLException {
                
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            User user = new User(null, null, null);
            conn = DriverManager.getConnection("jdbc:sqlite:studyMate.db");
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM Users WHERE name='" + name + "'" + " AND password='" + password + "'" 
                + " OR email='" + name + "'" + " AND password='" + password + "'");

            while (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }

            conn.close();
            rs.close();
            return user;
            
        } catch (Exception e) {
        } finally {
            if (s != null) {
                try {
                    rs.close();
                    s.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
