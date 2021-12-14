package com.poussu.studymate.wordgame;

import java.util.ArrayList;
import java.util.Collections;

import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;

public class WordGame {
    
    
    /** 
     * This method will check if the users translation for the given word is correct or not. It requires the word and the translation.
     * @param input the word thats translation is to be checked
     * @param translation the translation for the word 
     * @return boolean
     */
    public boolean translationCheck(Word input, String translation) {
        if (input.getTranslation().equals(translation)) {
            return true;
        }
        return false;
    }

    
    /** 
     * This method will make a randomised list of words by combining all the words from the lists that are chosen
     * @param list is the list that contains the names of the lists that will be used for mixed list creation
     * @return ArrayList<Word>
     */
    public ArrayList<Word> randomWordList(ArrayList<String> list) {
        EveryList el = new EveryList();
        ArrayList<Word> randomWords = new ArrayList<>();

        if (list != null) {
            for (WordList wl: el.getWordLists()) {
                if (list.contains(wl.getName())) {
                    randomWords.addAll(wl.getList());
                }
            }
        }

        Collections.shuffle(randomWords);

        return randomWords;
    }
}
