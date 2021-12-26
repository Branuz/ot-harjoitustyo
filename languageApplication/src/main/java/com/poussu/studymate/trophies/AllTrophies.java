package com.poussu.studymate.trophies;
import java.util.HashMap;

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
}
