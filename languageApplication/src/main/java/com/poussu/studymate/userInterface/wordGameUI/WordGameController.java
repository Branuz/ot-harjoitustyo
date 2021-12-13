package com.poussu.studymate.userInterface.wordGameUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.wordgame.WordGame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WordGameController implements Initializable{
    private StudyMateUi m = new StudyMateUi();
    private ArrayList<Word> randomWords;
    private int currentWord = 0;
    private int correctWordCount = 0;
    private WordGame game = new WordGame();

    @FXML
    Label wordLabel;
    @FXML
    Label counterLabel;
    @FXML
    TextField translationField;
    @FXML
    Label doneLabel;
    @FXML
    Label answerLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        randomWords = game.randomWordList();
        counterLabel.setText("0/" + randomWords.size());
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
        if(currentWord < randomWords.size()) {
            if (game.translationCheck(randomWords.get(currentWord), translationField.getText().toString())) {
                answerLabel.setText("");
                correctWordCount++;
                currentWord++;
                counterLabel.setText(correctWordCount + "/" + randomWords.size());
                
                if(currentWord < randomWords.size()) {
                    wordLabel.setText(randomWords.get(currentWord).getWord());
                }

                if(currentWord == randomWords.size()) {
                    doneLabel.setText("Congrats you finished everything!");
                }
            } else {
                answerLabel.setText("Wrong answer, try again.");
            }
        }
    }

    @FXML
    private void nextButton() {
        
    }

}
