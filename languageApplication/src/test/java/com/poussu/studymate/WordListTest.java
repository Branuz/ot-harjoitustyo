package com.poussu.studymate;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;

import org.junit.Before;
import org.junit.Test;

public class WordListTest {
    private WordList w;

    @Before
    public void setUp(){
        w = new WordList("Kuukaudet");
    }

    @Test
    public void wordListNameSetup(){
        w.setName("Viikot");
        assertEquals("Viikot", w.getName());
    }

    @Test
    public void listContainsWordList(){
        ArrayList<Word> list = new ArrayList<>();
        list.add(new Word("puhe", "speech"));
        w.setList(list);

        assertEquals("puhe", w.getList().get(0).getWord());
    }

    @Test
    public void listCorrectName(){
        assertEquals("Kuukaudet", w.getName());
    }

    
}
