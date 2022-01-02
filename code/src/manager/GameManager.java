package manager;

import classes.Boucleur;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import launcher.Launcher;

import java.io.IOException;

public class GameManager {
    private final Stage myStage;

    public GameManager(Stage myStage) {
        this.myStage = myStage;

        //Titre + Icone + page d'accueil
        myStage.setTitle("Jeu canap' pêche");
        myStage.getIcons().add(new Image("/img/fishIcon.png"));
        try {
            Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetreAccueil.fxml"));
            this.getMyStage().setScene(new Scene(racine));
            this.getMyStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startNewGame() {
        Boucleur b = new Boucleur();
        while(true) {
            //b.tourDeBoucle();
        }
    }


    //GETTERS ET SETTERS
    public Stage getMyStage() {
        return myStage;
    }
}
