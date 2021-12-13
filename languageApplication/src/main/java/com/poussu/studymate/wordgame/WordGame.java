package com.poussu.studymate.wordgame;

import java.util.ArrayList;
import java.util.Collections;

import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;
import com.poussu.studymate.userInterface.wordGameUI.WordGameMenu;

public class WordGame {
    
    public boolean translationCheck(Word input, String translation) {
        if(input.getTranslation().equals(translation)) {
            return true;
        }
        return false;
    }

    public ArrayList<Word> randomWordList() {
         WordGameMenu wordmenu = new WordGameMenu();
         EveryList el = new EveryList();
         ArrayList <Word> randomWords = new ArrayList<>();

         if (wordmenu.getChosenList().size() > 0) {
            for(WordList wl: el.getWordLists()) {
                if (wordmenu.getChosenList().contains(wl.getName())) {
                    randomWords.addAll(wl.getList());
                }
            }
         }

         Collections.shuffle(randomWords);

        return randomWords;
    }
}
