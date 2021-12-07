package com.poussu.studymate.dictionaryUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.poussu.studymate.Main;
import com.poussu.studymate.dictionary.EveryList;
import com.poussu.studymate.dictionary.WordList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.beans.binding.Bindings;

public class DictionaryMenu implements Initializable{

    private Main m = new Main();
    private static WordList wlist;

    @FXML
    private ListView<String> myListView;
    @FXML
    private TextField listName;

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
        wlist = new WordList(listName.getText().toString());
        m.changeScene("dictionary-addNewMenu.fxml");
    }
    
    
    @FXML
    private void logOutButton() throws IOException{
        m.changeScene("login-view.fxml");
    }

    @FXML
    private void mainMenuButton() throws IOException{
        m.changeScene("main-menu.fxml");
    }

    //Adds editing and deleting for list items
    private void cellEditorSettings(){
        myListView.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();
            ContextMenu contextMenu = new ContextMenu();


            MenuItem editItem = new MenuItem();
            editItem.textProperty().bind(Bindings.format("Edit \"%s\"", cell.itemProperty()));
            editItem.setOnAction(event -> {
                String item = cell.getItem();
                // code to edit item...
            });

            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
            deleteItem.setOnAction(event -> myListView.getItems().remove(cell.getItem()));
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

}
