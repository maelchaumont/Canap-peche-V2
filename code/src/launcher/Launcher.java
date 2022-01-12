package launcher;


import classes.highscores.ChargeurHS;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import classes.GameManager;
import view.FenetreAccueil;

import java.io.IOException;
import java.util.Map;


public class Launcher extends Application {

    private GameManager theManager;

    @Override
    public void start(Stage myStage) throws IOException {
        //Création GameManager
        theManager = new GameManager(myStage);

        //Titre + Icone + page d'accueil
        myStage.setTitle("Jeu canap' pêche");
        myStage.getIcons().add(new Image("/img/fishIcon.png"));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
            loader.setController(new FenetreAccueil(theManager));
            Parent racine = loader.load();
            myStage.setScene(new Scene(racine));
            myStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //nav = new Navigator(myStage);
        //nav.changeScene("vueAccueil");

        //SauvegardeurHS s = new SauvegardeurHS();
        //s.sauvegardeHS("Machin", 46);
        ChargeurHS c = new ChargeurHS();
        Map<String, Integer> m = c.chargeHS();
        System.out.println(m);
    }


    public GameManager getTheManager() {
        return theManager;
    }

    public void setTheManager(GameManager theManager) {
        this.theManager = theManager;
    }
}
