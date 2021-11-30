package com.poussu.studymate;
import java.sql.*;

public class DataBaseConnection {
    private Connection conn = null;

    public void connect(String command, String type, String[]userPara) {
        PreparedStatement p = null;
        try {
            String url = "jdbc:sqlite:studyMate.db";
            conn = DriverManager.getConnection(url);
            p = conn.prepareStatement(command);

            if (type == "CREATE") {
                Statement s = conn.createStatement();
                s.execute(command);
            }
            
            if (type == "INSERT") {
                for (int i = 0; i < userPara.length; i++) {
                    p.setString(i + 1, userPara[i]);
                }
                p.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (p != null) {
                    p.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
