package com.poussu.studymate;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.ArrayList;

import com.poussu.studymate.dataBaseHandler.ConnectionManager;
import com.poussu.studymate.dataBaseHandler.DatabaseUpdater;
import com.poussu.studymate.dataBaseHandler.ListManager;
import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.WordList;

import org.junit.Before;
import org.junit.Test;

public class dbUpdaterTest {
    
    private DatabaseUpdater db;
    private ListManager lm;
    private Connection conn;

    @Before
    public void setup() throws Exception{
        conn = ConnectionManager.getConnection();
        db = new DatabaseUpdater();
        lm = new ListManager();
    }

    @Test
    public void tableCreationAndInsertingWorks() throws Exception{
        String statement = "INSERT INTO List(word, translation, user, name) VALUES (?,?,?,?)";
        String[] userPara = {"Maanantai", "Monday", "TestAdmin", "Weekdays"};

        db.databaseInsert(conn, statement, userPara);
        conn = ConnectionManager.getConnection();
        ArrayList<WordList> lists = lm.getSavedLists(conn, "TestAdmin");
        assertEquals("Weekdays", lists.get(0).getName());
        assertEquals("Maanantai", lists.get(0).getList().get(0).getWord());
    }
}
