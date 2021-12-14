package com.poussu.studymate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.ArrayList;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.wordgame.WordGame;

import org.junit.Before;
import org.junit.Test;

public class wordGameTest {

    private WordGame game;
    private DatabaseUpdater db;
    private Connection conn;

    @Before
    public void setUp() throws Exception{
        game = new WordGame();
        db = new DatabaseUpdater();


        conn = ConnectionManager.getConnection();
        String[] values = {"Maanantai", "Monday", "TestAdmin", "TestList"};
        String statement = "INSERT INTO List(word, translation, user, name) VALUES (?,?,?,?)";
        db.databaseInsert(conn, statement, values);
    
    }

    @Test
    public void correctTranslation(){
        assertTrue(game.translationCheck(new Word("Maanantai", "Monday"), "Monday"));
    }

    @Test
    public void falseTranslation(){
        assertFalse(game.translationCheck(new Word("Maanantai", "Monday"), "asda"));
    }

    @Test
    public void randomWordListCheck(){
        ArrayList<String> list = new ArrayList<>();
        list.add("TestList");
        ArrayList<Word> wordList = game.randomWordList(list);
        assertEquals("Monday", wordList.get(0).getTranslation());

    }
}
