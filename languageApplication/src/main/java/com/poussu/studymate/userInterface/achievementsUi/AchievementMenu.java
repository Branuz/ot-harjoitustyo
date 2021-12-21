package com.poussu.studymate.userInterface.achievementsUi;

import java.io.IOException;

import com.poussu.studymate.StudyMateUi;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class AchievementMenu {

    private StudyMateUi m = new StudyMateUi();

    @FXML
    ImageView hunredWordIcon;
    
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
    private void shadowChange(){
        hunredWordIcon.setEffect(null);
    }
}
