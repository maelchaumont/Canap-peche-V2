package launcher;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class Launcher extends Application {

    @Override
    public void start(Stage myStage) {
        try {
            Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
            myStage.setScene(new Scene(racine));
            myStage.show();
        } catch (IOException e) {
            System.err.println("erreur dans start :" + e.getMessage());
        }
    }

}
