package com.poussu.studymate.userInterface.wordGameUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.WordList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class WordGameMenu implements Initializable {
    private StudyMateUi m = new StudyMateUi();
    private static ArrayList<String> chosenLists;

    @FXML
    private ListView<String> myListView;
    @FXML
    private TextField listName;
    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ArrayList<WordList> everyL = new EveryList().getWordLists();
        if(everyL.size()>0) {
            for(WordList w : everyL){
                 myListView.getItems().add(w.getName());
                 }
            }
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
    private void startGameButton() throws IOException {
       chosenLists =  new ArrayList<>();
       chosenLists.addAll(myListView.getSelectionModel().getSelectedItems());
       if(myListView.getSelectionModel().getSelectedItems().size()>0) {
        m.changeScene("wordGame-gameMenu.fxml");
       } else {
           errorLabel.setText("Select a list of words!");
       }
    }

    public ArrayList<String> getChosenList(){
        return chosenLists;
    }
}
