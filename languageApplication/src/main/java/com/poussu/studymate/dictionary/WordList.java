package com.poussu.studymate.dictionary;

import java.util.ArrayList;

public class WordList {
    private String name;
    private ArrayList<Word> list;
    /**
     * This constructs a list with specified name and it will contain all the words attached to it.
     * @param name the name of the WordList
     */

    public WordList(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    
    /** 
     * Used for getting the list.
     * @return ArrayList<Word>
     */
    public ArrayList<Word> getList() {
        return list;
    }

    
    /** 
     * Used for getting the name of the list.
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Used for setting up a new list.
     * @param list
     */
    public void setList(ArrayList<Word> list) {
        this.list = list;
    }

    
    /** 
     * Used for setting up the name of the list.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
