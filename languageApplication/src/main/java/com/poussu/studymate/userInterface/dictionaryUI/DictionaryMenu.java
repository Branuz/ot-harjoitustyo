package com.poussu.studymate.userInterface.dictionaryUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.WordList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.beans.binding.Bindings;

public class DictionaryMenu implements Initializable{

    private StudyMateUi m = new StudyMateUi();
    private static WordList wlist;
    private static String editList;


    @FXML
    private ListView<String> myListView;
    @FXML
    private TextField listName;
    @FXML Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<WordList> everyL = new EveryList().getWordLists();
        if(everyL.size()>0) {
            for(WordList w : everyL){
                myListView.getItems().add(w.getName());
            }
        cellEditorSettings();
        }
    }

    @FXML
    private void newList() throws IOException{
        if(listName.getText().toString().isEmpty()){
            errorLabel.setText("List name is empty!");
        }else {
            wlist = new WordList(listName.getText().toString());
            m.changeScene("dictionary-addNewMenu.fxml");
        }
    }
    
    
    @FXML
    private void logOutButton() throws IOException{
        m.changeScene("login-view.fxml");
    }

    @FXML
    private void mainMenuButton() throws IOException{
        m.changeScene("main-menu.fxml");
    }

    @FXML
    private void achievementButton() throws IOException{
        m.changeScene("achievements.fxml");
    }

    //Adds editing and deleting for list items
    private void cellEditorSettings() {
        myListView.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();
            ContextMenu contextMenu = new ContextMenu();


            MenuItem editItem = new MenuItem();
            editItem.textProperty().bind(Bindings.format("Edit \"%s\"", cell.itemProperty()));
            editItem.setOnAction(event -> {
                String item = cell.getItem();
                editList = item;
                try {
                    m.changeScene("dictionary-addNewMenu.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
            deleteItem.setOnAction(event -> {
                Connection conn;
                try {
                    conn = ConnectionManager.getConnection();
                    DatabaseUpdater db = new DatabaseUpdater();
                    String statement = "DELETE FROM List WHERE name = ?";
                    String[] userPara= {cell.getItem().toString()};

                    db.databaseInsert(conn, statement, userPara);
                    myListView.getItems().remove(cell.getItem());
            } catch (Exception e) {
                e.printStackTrace();
            }
            });
            
            contextMenu.getItems().addAll(editItem, deleteItem);

            cell.textProperty().bind(cell.itemProperty());
            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });
    }

    public WordList getWlist() {
        return wlist;
    }

    public String getEditList() {
        return editList;
    }

    public void setWlist(String name){
        wlist = new WordList(name);
    }

}
