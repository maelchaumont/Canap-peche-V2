package launcher;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import classes.GameManager;
import controleurs.FenetreAccueil;

import java.io.IOException;


public class Launcher extends Application {

    @Override
    public void start(Stage myStage) throws IOException {
        //Création GameManager
        GameManager theManager = new GameManager(myStage);

        //Titre + Icone + page d'accueil
        myStage.setTitle("Jeu canap' pêche");
        myStage.getIcons().add(new Image("/img/fishIcon.png"));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
            loader.setController(new FenetreAccueil(theManager));
            Parent racine = loader.load();
            Scene theScene = new Scene(racine);
            theScene.getStylesheets().add("css/styles.css");
            myStage.setScene(theScene);
            myStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
