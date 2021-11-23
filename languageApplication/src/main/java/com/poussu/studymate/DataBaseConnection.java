package com.poussu.studymate;
import java.sql.*;

public class DataBaseConnection {

    public void connect(String command, String type, String[]userPara) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:studyMate.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            PreparedStatement p = conn.prepareStatement(command);

            if(type=="CREATE"){
                Statement s = conn.createStatement();
                s.execute(command);
            }
            
            if(type=="INSERT"){
                for(int i=0; i<userPara.length; i++){
                    p.setString(i+1, userPara[i]);
                }
                p.executeUpdate();
                System.out.println("Account created!");
            }

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
