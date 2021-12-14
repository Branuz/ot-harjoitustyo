package com.poussu.studymate.dictionary;

import java.sql.Connection;
import java.util.ArrayList;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.ListManager;
import com.poussu.studymate.userInterface.startUI.Login;

public class EveryList {
    private Login l = new Login();
    
    
    /** 
     * Used for getting all the word lists.
     * @return returns ArrayList<WordList> 
     */
    public ArrayList<WordList> getWordLists() {
        Connection conn = null;
        ListManager lm = new ListManager();
        try {
            conn = ConnectionManager.getConnection();
            ArrayList<WordList> lists =   lm.getSavedLists(conn, l.getLoggedUser().getName());
            
            return lists;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
