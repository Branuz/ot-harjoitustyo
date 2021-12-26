package com.poussu.studymate.databasehandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseUpdater {

    
    /** Inserts, updates and deletes from database with given connection, statement and parameters.
     * @param conn connection for the database
     * @param statement statement to be inserted for the database
     * @param userPara parameters of the statamenet
     */
    
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

    
    /** 
     * Creates a new table for the database with given connection and statement
     * @param conn connection for the table creation
     * @param statement statamenet for table creation
     */
    
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
