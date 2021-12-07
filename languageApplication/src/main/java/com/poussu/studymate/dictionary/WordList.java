package com.poussu.studymate.dictionary;

import java.util.ArrayList;

public class WordList {
    private String name;
    private ArrayList<Word> list;

    //A list that contains all the words attached to it.
    public WordList(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    public ArrayList<Word> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public void setList(ArrayList<Word> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
