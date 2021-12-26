package com.poussu.studymate.trophies;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.TrophyManager;
import com.poussu.studymate.userInterface.startUI.Login;

public class AllTrophies {
    private HashMap<String,Trophy> list;

    public AllTrophies(){
        this.list = new HashMap<>();
        list.put("hunredTranslated", new Trophy("hunredTranslated", false, 100, "Word"));
        list.put("fiftyTranslated", new Trophy("fiftyTranslated", false, 50, "Word"));
        list.put("tenTranslated", new Trophy("tenTranslated", false, 10, "Word"));
        list.put("firstGame", new Trophy("firstGame", false, 1, "Game"));
        list.put("listOfTwentyWords", new Trophy("listOfTwentyWords", false, 20, "Word"));
        list.put("firstList", new Trophy("firstList", false, 1, "List"));
    }

    public HashMap<String, Trophy> getList() {
        return list;
    }

    public ArrayList<String> getCompletedTrophies() {
        ArrayList<String> completed = new ArrayList<>();
        Login l = new Login();

        TrophyManager tm = new TrophyManager();
        try {
            Connection conn = ConnectionManager.getConnection();
            Stream<Entry<String, Trophy>> trophies = tm.getSavedLists(conn, l.getLoggedUser().getName())
            .getList().entrySet().stream()
            .filter(a->a.getValue().getCompleted());
            
            trophies.forEach(x -> completed.add(x.getValue().getName()));            

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return completed;
    }
}
