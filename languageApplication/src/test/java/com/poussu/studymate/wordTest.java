package com.poussu.studymate;
import static org.junit.Assert.assertEquals;
import com.poussu.studymate.dictionaryUI.Word;

import org.junit.Before;
import org.junit.Test;

public class wordTest {
   private Word w;

    @Before
    public void setUp(){
        w = new Word("Puu", "Tree");
    }

    @Test
    public void wordInsertCorrect() {
        assertEquals("Puu", w.getWord());
    }

    @Test
    public void translationInsertCorrect() {
        assertEquals("Tree", w.getTranslation());
    }

    @Test
    public void setWordIsWorking() {
        w.setWord("Maksa");
        assertEquals("Maksa", w.getWord());
    }

    @Test
    public void setTranslationIsWorking() {
        w.setTranslation("Liver");
        assertEquals("Liver", w.getTranslation());
    }

}
