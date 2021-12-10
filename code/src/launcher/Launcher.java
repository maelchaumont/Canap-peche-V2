package launcher;

import classes.DeplaceurLent;
import classes.DeplaceurRapide;
import fxtimer.FXTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Launcher extends Application {
    private static Stage myStage;

    @FXML
    private AnchorPane anchor;

    @Override
    public void start(Stage myStage) {

        try {
            Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
            myStage.setScene(new Scene(racine));
            myStage.setTitle("Jeu canap' pêche");

            DeplaceurRapide dr = new DeplaceurRapide();
            anchor = new AnchorPane();
            dr.deplacer(anchor, 100, 50);

            myStage.show();
        } catch (IOException e) {
            System.err.println("erreur dans start :" + e.getMessage());
        }
        //FXTimer timer = new FXTimer();
    }
}
