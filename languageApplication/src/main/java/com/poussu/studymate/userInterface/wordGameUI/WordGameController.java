package com.poussu.studymate.userInterface.wordGameUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.trophies.AllTrophies;
import com.poussu.studymate.userInterface.startUI.Login;
import com.poussu.studymate.wordgame.WordGame;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class WordGameController implements Initializable{
    private StudyMateUi m = new StudyMateUi();
    private Login l = new Login();
    private ArrayList<Word> randomWords;
    private int currentWord = 0;
    private int correctWordCount = 0;
    private int correcWordInRow = 0;
    private WordGame game = new WordGame();
    private Boolean checked = false;

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
    @FXML
    Label correctLabel;
    @FXML
    StackPane trophyPopper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseUpdater manager = new DatabaseUpdater();
        Connection conn;
        AllTrophies trophies = new AllTrophies();
        
        if(!trophies.getCompletedTrophies(l.getLoggedUser().getName()).contains("firstGame")) {
            showTrophyPopUp();
        }

        try {
            conn = ConnectionManager.getConnection();
            String trophyStatement = "INSERT INTO Trophies(trophy, user) VALUES (?,?)";
            String[] trophyValueStrings = {"firstGame", l.getLoggedUser().getName()};
            manager.databaseInsert(conn, trophyStatement, trophyValueStrings);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        WordGameMenu gamemenu = new WordGameMenu();
        randomWords = game.randomWordList(gamemenu.getChosenList());
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
    private void achievementButton() throws IOException{
        m.changeScene("achievements.fxml");
    }

    @FXML
    private void checkButton() throws Exception {
        if(currentWord < randomWords.size()) {
            if (game.translationCheck(randomWords.get(currentWord), translationField.getText().toString())) {
                answerLabel.setText("");
                if(!checked) {
                    correctWordCount++;
                    checked = true;
                }
                counterLabel.setText(correctWordCount + "/" + randomWords.size());
                if(currentWord < randomWords.size()) {
                    correctLabel.setText("Correct!");
                    correcWordInRow++;
                    
                    if (correcWordInRow==10 || correcWordInRow==50 || correcWordInRow==100) {

                        DatabaseUpdater manager = new DatabaseUpdater();
                        Connection conn = ConnectionManager.getConnection();
                        String amount = "";
                        AllTrophies trophies = new AllTrophies();
                        if(correcWordInRow==10) {
                            amount = "tenTranslated";
                            if(!trophies.getCompletedTrophies(l.getLoggedUser().getName()).contains(amount)) {
                                showTrophyPopUp();
                            }
                        }

                        if(correcWordInRow==50) {
                            amount = "fiftyTranslated";
                            if(!trophies.getCompletedTrophies(l.getLoggedUser().getName()).contains(amount)) {
                                showTrophyPopUp();
                            }
                        }

                        if(correcWordInRow==100) {
                            amount = "hunredTranslated";
                            if(!trophies.getCompletedTrophies(l.getLoggedUser().getName()).contains(amount)) {
                                showTrophyPopUp();
                            }
                        }
                        String trophyStatement = "INSERT INTO Trophies(trophy, user) VALUES (?,?)";
                        String[] trophyValueStrings = {amount, l.getLoggedUser().getName()};
                        manager.databaseInsert(conn, trophyStatement, trophyValueStrings);
                    }
                }

                if(currentWord == randomWords.size()) {
                    doneLabel.setText("Congrats you finished everything!");
                }
            } else {
                answerLabel.setText("Wrong answer, try again.");
                correcWordInRow = 0;
            }
        }
    }

    @FXML
    private void nextButton() {
        currentWord++;
        answerLabel.setText("");
        translationField.setText("");
        correctLabel.setText("");
        checked = false;
        if(currentWord < randomWords.size()){
            wordLabel.setText(randomWords.get(currentWord).getWord());
        }
        if(currentWord == randomWords.size()) {
            doneLabel.setText("Congrats you finished everything!");
        }
    }

    private void showTrophyPopUp() {
        trophyPopper.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(5));
        visiblePause.setOnFinished(event -> trophyPopper.setVisible(false));
        visiblePause.play();
    }

}
