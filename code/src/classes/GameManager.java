package classes;

import classes.*;
import classes.highscores.ChargeurHS;
import classes.highscores.Highscores;
import classes.highscores.SauvegardeurHS;
import javafx.collections.ListChangeListener;
import javafx.stage.Stage;

public class GameManager {
    private final Stage myStage;
    private Pecheur lePecheur;
    private VaguePoissons vP;
    private Highscores hS;

    public GameManager(Stage myStage) {
        this.myStage = myStage;
        this.vP = new VaguePoissons(7);
        this.hS = new Highscores(new SauvegardeurHS(), new ChargeurHS());
        this.lePecheur = new Pecheur("temp"); //temporaire

        vP.listPoissonsProperty().addListener(new ListChangeListener<Poisson>() {
            @Override
            public void onChanged(Change<? extends Poisson> c) {
                System.out.println("(temporaire) : listPoisson changée");
            }
        });
    }



    public void startNewGame() {
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

    public Highscores gethS() {
        return hS;
    }

    public void sethS(Highscores hS) {
        this.hS = hS;
    }

    public Pecheur getLePecheur() {
        return lePecheur;
    }

    public void setLePecheur(Pecheur lePecheur) {
        this.lePecheur = lePecheur;
    }
}
