package com.poussu.studymate.dataBaseHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInsert {

    //Adds the word into the database
    public void databaseInsert(Connection conn, String statement ,String[] userPara){
        try {
           PreparedStatement p = conn.prepareStatement(statement);

            for (int i = 0; i < userPara.length; i++) {
                p.setString(i + 1, userPara[i]);
            }
            p.executeUpdate();
            conn.close();
            p.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void databaseCreate(Connection conn, String statement){
        try {
           Statement s = conn.createStatement();
           s.execute(statement);    
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
