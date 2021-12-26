package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poussu.studymate.trophies.AllTrophies;

public class TrophyManager {
    
    
    /** 
     * Fetches all the trophies that are are available for the user and updates their completion statuses if the user has done them. 
     * Requires a connection and username.
     * @param conn connection for the database
     * @param user username information
     * @return AllTrophies after updating their completion status
     * @throws SQLException
     */
    public AllTrophies getSavedLists(Connection conn, String user) throws SQLException {
        ResultSet rs = null;
        Statement s = null;
        AllTrophies trophies = new AllTrophies();

        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM Trophies WHERE user='" + user + "';");

            while (rs.next()) {
                if (trophies.getList().get(rs.getString("trophy")) != null) {
                    trophies.getList().get(rs.getString("trophy")).setCompleted(true);
                }
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
