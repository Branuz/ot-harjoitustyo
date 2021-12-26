package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poussu.studymate.trophies.AllTrophies;

public class TrophyManager {
    
    public AllTrophies getSavedLists(Connection conn, String user) throws SQLException {
        ResultSet rs = null;
        Statement s = null;
        AllTrophies trophies = new AllTrophies();

        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM Trophies WHERE user='" + user + "';");

            while (rs.next()) {
                trophies.getList().get(rs.getString("trophy")).setCompleted(true);;
            }

            return trophies;
            
        } finally {
            try {
                rs.close();
                s.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
