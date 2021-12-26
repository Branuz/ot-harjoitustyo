package com.poussu.studymate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.ArrayList;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.trophies.AllTrophies;
import com.poussu.studymate.trophies.Trophy;

import org.junit.Before;
import org.junit.Test;

public class TrophieTest {
    private Trophy trophy;
    private AllTrophies allTrophies;
    @Before
    public void setup(){
        trophy = new Trophy("testTrophy", false);
        allTrophies = new AllTrophies();
    }

    @Test
    public void getNameCorrect() {
        assertEquals("testTrophy", trophy.getName());
    }

    @Test
    public void setNameCorrect() {
        trophy.setName("hunredWords");
        assertEquals("hunredWords", trophy.getName());
    }

    @Test
    public void setStatusCorrect() {
        trophy.setCompleted(true);
        assertTrue(trophy.getCompleted());
    }

    @Test
    public void allTrophiesSetupWorks() {
        assertEquals(6, allTrophies.getList().size());
    }

    @Test
    public void allTrophiesAfterInsertWorks() throws Exception {
        DatabaseUpdater manager = new DatabaseUpdater();
        Connection conn = ConnectionManager.getConnection();
        String trophyStatement = "INSERT INTO Trophies(trophy, user) VALUES (?,?)";
        String[] trophyValueStrings = {"firstGame", "testAdmin"};
        manager.databaseInsert(conn, trophyStatement, trophyValueStrings);
        ArrayList<String> completed =  allTrophies.getCompletedTrophies("testAdmin");
        assertEquals("firstGame", completed.get(0));
    }
}
