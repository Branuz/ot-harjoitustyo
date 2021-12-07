package com.poussu.studymate.dataBaseHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;

public class ListManager {

    //Fetches all the words from the database and makes corresponding lists of them based on their names.
    public ArrayList<WordList> getSavedLists(Connection conn, String user) throws SQLException{
        
        try {
            ArrayList<WordList> lists = new ArrayList<>();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT DISTINCT name FROM List WHERE user='" + user + "';");

            while (rs.next()) {
                lists.add(new WordList(rs.getString("name")));
                }

                for(WordList l : lists){
                    rs =  s.executeQuery("SELECT word, translation FROM List WHERE name='" + l.getName() + "';");
                    while (rs.next()) {
                        l.getList().add(new Word(rs.getString("word"), (rs.getString("translation"))));
                        }
                }

            conn.close();
            rs.close();

            //Returns a list which contains all the wordlists created.
            return lists;
            
        } catch (Exception e) {
            if(conn!=null)conn.close();
            System.out.println(e);
            }
        return null;
        }

        public void removeList(Connection conn){
            try {
                
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
}
