package manager;

import classes.BoucleurLent;
import classes.BoucleurRapide;
import classes.Poisson;
import classes.VaguePoissons;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.FenetreAccueil;
import view.FenetrePrincipale;

import java.io.IOException;

public class GameManager {
    private final Stage myStage;
    private VaguePoissons vP = new VaguePoissons(7);

    public GameManager(Stage myStage) {
        this.myStage = myStage;

        //Titre + Icone + page d'accueil
        myStage.setTitle("Jeu canap' pêche");
        myStage.getIcons().add(new Image("/img/fishIcon.png"));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
            loader.setController(new FenetreAccueil(this));
            Parent racine = loader.load();
            this.getMyStage().setScene(new Scene(racine));
            this.getMyStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void startNewGame() {
        for (Poisson fish:
                this.getvP().getListPoissons()) {
            ImageView imgViewPoisson = new ImageView();
            imgViewPoisson.setImage(fish.getSpritePoisson());
            imgViewPoisson.setFitHeight(50);
            imgViewPoisson.setFitWidth(60);
            imgViewPoisson.translateXProperty().bind(fish.cooXPoissonProperty());
            imgViewPoisson.translateYProperty().bind(fish.cooYPoissonProperty());
        }
        //observer vaguePoisson dans le modèle, ici je l'ai mis dans la vue mais il faudrait le mettre ds le modèle

        BoucleurRapide boucleurRapide = new BoucleurRapide();
        BoucleurLent boucleurLent = new BoucleurLent();
        Thread t1 = new Thread(boucleurRapide);
        Thread t2 = new Thread(boucleurLent);
        t1.start();
        t2.start();
    }


    //GETTERS ET SETTERS
    public Stage getMyStage() {
        return myStage;
    }

    public VaguePoissons getvP() {
        return vP;
    }

    public void setvP(VaguePoissons vP) {
        this.vP = vP;
    }
}
