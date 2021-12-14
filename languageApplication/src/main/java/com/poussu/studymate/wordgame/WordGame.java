package com.poussu.studymate.wordgame;

import java.util.ArrayList;
import java.util.Collections;

import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;

public class WordGame {
    
    public boolean translationCheck(Word input, String translation) {
        if(input.getTranslation().equals(translation)) {
            return true;
        }
        return false;
    }

    public ArrayList<Word> randomWordList(ArrayList<String> list) {
         EveryList el = new EveryList();
         ArrayList <Word> randomWords = new ArrayList<>();

         if (list!=null) {
            for(WordList wl: el.getWordLists()) {
                if (list.contains(wl.getName())) {
                    randomWords.addAll(wl.getList());
                }
            }
         }

         Collections.shuffle(randomWords);

        return randomWords;
    }
}
