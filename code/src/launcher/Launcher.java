package launcher;


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
        nav.changeScene("vuePrincipale");

        //Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
        //myStage.setScene(new Scene(racine));
        //myStage.setTitle("Jeu canap' pêche");

            /*
            DeplaceurRapide dr = new DeplaceurRapide();
            anchor = new AnchorPane();
            dr.deplacer(anchor, 100, 50);
             */
        //FXTimer timer = new FXTimer();
    }
}
