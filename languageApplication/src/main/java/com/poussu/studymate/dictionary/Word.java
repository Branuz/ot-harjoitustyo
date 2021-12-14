package com.poussu.studymate.dictionary;

public class Word {
    private String word;
    private String translation;
    /**
     * This constructs a word with specified original word and a translation for it
     * @param word the word of the word
     * @param translation the translation of the word
     */

    // An object which contains the word and a corresponding translation for it
    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    
    /** 
     * Used for getting the word
     * @return String
     */
    public String getWord() {
        return word;
    }

    
    /** 
     * Used for getting the translation
     * @return String
     */
    public String getTranslation() {
        return translation;
    }

    
    /** 
     * Used for setting the word with a specified word
     * @param word the word of the word
     */
    public void setWord(String word) {
        this.word = word;
    }

    
    /** 
     * Used for setting the translation of the word with a specified translation
     * @param translation the translation of the word
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
