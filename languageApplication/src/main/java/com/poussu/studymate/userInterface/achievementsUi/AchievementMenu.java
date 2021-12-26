package com.poussu.studymate.userInterface.achievementsUi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.trophies.AllTrophies;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class AchievementMenu implements Initializable {

    private StudyMateUi m = new StudyMateUi();

    @FXML
    ImageView hunredWordIcon;

    @FXML
    ImageView listOfTwentyWords;

    @FXML
    ImageView fiftyWordIcon;

    @FXML
    ImageView tenWordIcon;

    @FXML
    ImageView firstGameIcon;

    @FXML
    ImageView firstList;

    
    /** 
     * Initializes the view of interface by showing those trophies that have been earned and keeping the rest hidden
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AllTrophies trophies = new AllTrophies();
        trophies.getCompletedTrophies().forEach(names -> shadowChange(names));        
    }
    
    
    /** 
     * Logs the user out of the application
     * @throws IOException
     */
    @FXML
    private void logOutButton() throws IOException {
        m.changeScene("login-view.fxml");
    }

    
    /** 
     * Forwards user into the mainmenu of the application.
     * @throws IOException
     */
    @FXML
    private void mainMenuButton() throws IOException {
        m.changeScene("main-menu.fxml");
    }

    
    /** 
     * Forwards user into the trophies section of the application.
     * @throws IOException
     */
    @FXML
    private void achievementButton() throws IOException{
        m.changeScene("achievements.fxml");
    }

    
    /** Changes the given trophy visible in the interface
     * @param name name of the given trophy
     */
    @FXML
    private void shadowChange(String name){
        if ("hunredTranslated" == name) {
            hunredWordIcon.setEffect(null);
        }

        if ("fiftyTranslated" == name) {
            fiftyWordIcon.setEffect(null);
        }

        if ("tenTranslated" == name) {
            tenWordIcon.setEffect(null);
        }

        if ("listOfTwentyWords" == name) {
            listOfTwentyWords.setEffect(null);
        }

        if ("firstGame" == name) {
            firstGameIcon.setEffect(null);
        }

        if ("firstList" == name) {
            firstList.setEffect(null);
        }
    }
}
