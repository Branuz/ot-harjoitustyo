package com.poussu.studymate.trophies;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.TrophyManager;

public class AllTrophies {
    
    private HashMap<String,Trophy> list;
    
    public AllTrophies(){
        this.list = new HashMap<>();
        list.put("hunredTranslated", new Trophy("hunredTranslated", false));
        list.put("fiftyTranslated", new Trophy("fiftyTranslated", false));
        list.put("tenTranslated", new Trophy("tenTranslated", false));
        list.put("firstGame", new Trophy("firstGame", false));
        list.put("listOfTwentyWords", new Trophy("listOfTwentyWords", false));
        list.put("firstList", new Trophy("firstList", false));
    }

    
    /** 
     * Used for getting the starting map containing all the trophies and their requirements using trophys name as a key and trophy as the value
     * @return HashMap<String, Trophy> map containing all the trophies
     */
    public HashMap<String, Trophy> getList() {
        return list;
    }

    
    /** 
     * Used for getting a list containing the names of all the tropies the user has completed.
     * @return ArrayList<String> containing the names of the completed trophies
     */
    public ArrayList<String> getCompletedTrophies(String user) {
        ArrayList<String> completed = new ArrayList<>();

        TrophyManager tm = new TrophyManager();
        try {
            Connection conn = ConnectionManager.getConnection();
            Stream<Entry<String, Trophy>> trophies = tm.getSavedLists(conn, user)
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
