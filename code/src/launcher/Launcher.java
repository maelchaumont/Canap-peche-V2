package launcher;

import fxtimer.FXTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Launcher extends Application {
    private static Stage myStage;


    @Override
    public void start(Stage myStage) {
        this.myStage = myStage;

        try {
            Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
            myStage.setScene(new Scene(racine));
            myStage.setTitle("Jeu canap' pêche");
            myStage.show();
        } catch (IOException e) {
            System.err.println("erreur dans start :" + e.getMessage());
        }
        //FXTimer timer = new FXTimer();
    }

    public static Stage getMyStage() {
        return myStage;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }
}
