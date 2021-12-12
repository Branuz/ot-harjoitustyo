package com.poussu.studymate.databasehandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseUpdater {

    //Does update executions such as deletions and insertions of lists and words.
    public void databaseInsert(Connection conn, String statement, String[] userPara) {
        PreparedStatement p = null;
        try {
            p = conn.prepareStatement(statement);

            for (int i = 0; i < userPara.length; i++) {
                p.setString(i + 1, userPara[i]);
            }
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    p.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        
    }

    //Used for creating new tables in the database
    public void databaseCreate(Connection conn, String statement) {
        Statement s  = null;

        try {
            s = conn.createStatement();
            s.execute(statement);    

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
