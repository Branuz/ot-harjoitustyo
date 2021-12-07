package com.poussu.studymate.dataBaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poussu.studymate.userData.User;

public class UserManager {
    public User getLoggedUser(String name, String password) throws SQLException{
                
        Connection conn = null;
        try {
            User user = new User(null, null, null);
            conn = DriverManager.getConnection("jdbc:sqlite:studyMate.db");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Users WHERE name='" + name + "'" + " AND password='" + password + "'" 
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
            if(conn!=null)conn.close();
            System.out.println(e);
            }
        return null;
        }
}
