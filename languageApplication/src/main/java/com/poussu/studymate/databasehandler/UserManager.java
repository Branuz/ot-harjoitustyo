package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poussu.studymate.userdata.User;

public class UserManager {

    
    /** 
     * Used for checking if the user is in the database and creating a user object if database contains the user. 
     * Is given the name or email of the account and the password of the account.
     * @param name username of the account or email of the account
     * @param password password of the account
     * @return User with filled details if login details were correct
     * @throws SQLException
     */

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
