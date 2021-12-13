package com.poussu.studymate.userInterface.wordGameUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.dictionary.WordList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WordGameController implements Initializable{
    private StudyMateUi m = new StudyMateUi();
    private WordGameMenu wordmenu = new WordGameMenu();
    private ArrayList<Word> randomWords;
    private int currentWord = 0;

    @FXML
    Label wordLabel;
    @FXML
    Label counterLabel;
    @FXML
    TextField trannslatinField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EveryList el = new EveryList();
        randomWords = new ArrayList<>();

        for(WordList wl: el.getWordLists()){
            if(wordmenu.getChosenList().contains(wl.getName())) {
                randomWords.addAll(wl.getList());
            }
        }
        counterLabel.setText("0/"+randomWords.size());
        Collections.shuffle(randomWords);
        wordLabel.setText(randomWords.get(currentWord).getWord());
    }

    @FXML
    private void logOutButton() throws IOException {
        m.changeScene("login-view.fxml");
    }

    @FXML
    private void mainMenuButton() throws IOException {
        m.changeScene("main-menu.fxml");
    }

    @FXML
    private void checkButton() {
        System.out.println(wordmenu.getChosenList());
    }

    @FXML
    private void nextButton() {
        
    }

}
