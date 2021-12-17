package navigate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.*;

import java.io.IOException;

public class Navigator {

    //constructeur
    public Navigator() {
    }


    public void changeScene(String name) {
        switch(name) {
            case "vueAccueil":
                try {
                    Stage thisStage = new Stage();
                    Parent racine = FXMLLoader.load(Navigator.class.getResource("/FXML/FenetreAccueil.fxml"));
                    thisStage.setScene(new Scene(racine));
                    thisStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case "vuePrincipale":
            case "vueHighscores":
        }
    }
}
