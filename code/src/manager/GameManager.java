package manager;

import classes.*;
import classes.highscores.ChargeurHS;
import classes.highscores.Highscores;
import classes.highscores.SauvegardeurHS;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import view.FenetreAccueil;

import java.io.IOException;

public class GameManager {
    private final Stage myStage;
    private VaguePoissons vP;
    private  Highscores hS;

    public GameManager(Stage myStage) {
        this.myStage = myStage;
        this.vP = new VaguePoissons(7);
        this.hS = new Highscores(new SauvegardeurHS(), new ChargeurHS());

        vP.listPoissonsProperty().addListener(new ListChangeListener<Poisson>() {
            @Override
            public void onChanged(Change<? extends Poisson> c) {
                System.out.println("(temporaire) : listPoisson changée");
            }
        });

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


        BoucleurRapide boucleurRapide = new BoucleurRapide(this.getvP());
        BoucleurLent boucleurLent = new BoucleurLent();
        Thread t1 = new Thread(boucleurRapide);
        Thread t2 = new Thread(boucleurLent);
        t1.start();
        t2.start();



        vP.getListPoissons().add(new PoissonBombe(5,5));
        vP.getListPoissons().get(3).setCooXPoisson(200);
        vP.getListPoissons().get(3).setPoids(45);
        vP.getListPoissons().get(3).setCooXPoisson(250);
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
