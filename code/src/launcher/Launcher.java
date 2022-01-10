package launcher;


import classes.highscores.ChargeurHS;
import javafx.application.Application;
import javafx.stage.Stage;
import manager.GameManager;

import java.io.IOException;
import java.util.Map;


public class Launcher extends Application {

    private GameManager theManager;

    @Override
    public void start(Stage myStage) throws IOException {
        //Création GameManager
        theManager = new GameManager(myStage);


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
