package com.poussu.studymate.dictionary;

public class Word {
    private String word;
    private String translation;

    // An object which contains the word and a corresponding translation for it
    public Word(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
