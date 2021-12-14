package com.poussu.studymate.databasehandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;

public class ListManager {

    //Fetches all the words from the database and makes corresponding lists of them based on their names.
    public ArrayList<WordList> getSavedLists(Connection conn, String user) throws SQLException {
        ResultSet rs = null;
        Statement s = null;
        try {
            ArrayList<WordList> lists = new ArrayList<>();
            s = conn.createStatement();
            rs = s.executeQuery("SELECT DISTINCT name FROM List WHERE user='" + user + "';");

            while (rs.next()) {
                lists.add(new WordList(rs.getString("name")));
            }

            for (WordList l : lists) {
                rs =  s.executeQuery("SELECT word, translation FROM List WHERE name='" + l.getName() + "';");
                while (rs.next()) {
                    l.getList().add(new Word(rs.getString("word"), (rs.getString("translation"))));
                }
            }

            //Returns a list which contains all the wordlists created.
            return lists;
            
        } finally {
            try {
                rs.close();
                s.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
