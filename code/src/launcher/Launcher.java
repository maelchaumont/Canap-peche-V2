package launcher;


import highscores.SauvegardeurHS;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import navigate.Navigator;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Launcher extends Application {

    public static Navigator nav;


    @Override
    public void start(Stage myStage) throws IOException {

        nav = new Navigator(myStage);
        nav.changeScene("vueAccueil");

        //Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
        //myStage.setScene(new Scene(racine));
        //myStage.setTitle("Jeu canap' pêche");
        //SauvegardeurHS s = new SauvegardeurHS();
        //s.sauvegardeHS("Machin", 46);
    }
}
