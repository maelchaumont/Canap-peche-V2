package navigate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {
    private Stage myStage;

    //constructeur
    public Navigator(Stage myStage) {
        this.myStage = myStage;
    }




    public Stage getMyStage() {
        return myStage;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }


    public void changeScene(String name) {
        this.getMyStage().setTitle("Jeu canap' pêche");

        switch(name) {
            case "vueAccueil":
                try {
                    Parent racine = FXMLLoader.load(Navigator.class.getResource("/FXML/FenetreAccueil.fxml"));
                    this.getMyStage().setScene(new Scene(racine));
                    this.getMyStage().show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "vuePrincipale":
                try {
                    Parent racine = FXMLLoader.load(Navigator.class.getResource("/FXML/FenetrePrincipale.fxml"));
                    this.getMyStage().setScene(new Scene(racine));
                    this.getMyStage().show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "vueHighscores":
        }
    }
}
