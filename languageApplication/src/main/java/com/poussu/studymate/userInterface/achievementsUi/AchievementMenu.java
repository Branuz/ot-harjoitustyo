package com.poussu.studymate.userInterface.achievementsUi;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Map.Entry;
import java.util.stream.Stream;

import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.TrophyManager;
import com.poussu.studymate.trophies.Trophy;
import com.poussu.studymate.userInterface.startUI.Login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class AchievementMenu implements Initializable {

    private StudyMateUi m = new StudyMateUi();
    private Login l = new Login();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TrophyManager tm = new TrophyManager();
        try {
            Connection conn = ConnectionManager.getConnection();
            Stream<Entry<String, Trophy>> trophies = tm.getSavedLists(conn, l.getLoggedUser().getName())
            .getList().entrySet().stream()
            .filter(a->a.getValue().getCompleted());
            
            trophies.forEach(x -> shadowChange(x.getValue().getName()));            

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
