package classes;

import classes.*;
import classes.highscores.ChargeurHS;
import classes.highscores.Highscores;
import classes.highscores.SauvegardeurHS;
import javafx.collections.ListChangeListener;
import javafx.stage.Stage;

import java.io.IOException;

public class GameManager {
    private final Stage myStage;
    private Pecheur lePecheur;
    private VaguePoissons vP;
    private Highscores hS;
    private int millisSleepBoucleurRapide;
    private int millisSleepBoucleurLent;
    private Timer theTimer;
    private Thread t1;
    private Thread t2;

    public GameManager(Stage myStage) {
        this.myStage = myStage;
        vP = new VaguePoissons(7);
        try {
            hS = new Highscores(new SauvegardeurHS(), new ChargeurHS());
            System.out.println(hS.getMapHighScores().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        millisSleepBoucleurRapide = 25;
        millisSleepBoucleurLent = 10000;
        lePecheur = new Pecheur("temp"); //temporaire

        vP.listPoissonsProperty().addListener(new ListChangeListener<Poisson>() {
            @Override
            public void onChanged(Change<? extends Poisson> c) {
                System.out.println("(temporaire) : listPoisson changée");
            }
        });
    }



    public void startNewGame() {
        BoucleurRapide boucleurRapide = new BoucleurRapide(millisSleepBoucleurRapide, vP, this);
        BoucleurLent boucleurLent = new BoucleurLent(millisSleepBoucleurLent, vP);
        t1 = new Thread(boucleurRapide);
        t2 = new Thread(boucleurLent);
        t1.start();
        t2.start();


        vP.getListPoissons().add(new PoissonBombe(5,5));
        vP.getListPoissons().get(3).setCooXPoisson(200);
        vP.getListPoissons().get(3).setPoids(45);
        vP.getListPoissons().get(3).setCooXPoisson(250);
    }

    public void gameOver() {
        System.out.println("game over ;)");
        t2.stop();
        t1.stop();
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

    public int getMillisSleepBoucleurRapide() {
        return millisSleepBoucleurRapide;
    }

    public void setMillisSleepBoucleurRapide(int millisSleepBoucleurRapide) {
        this.millisSleepBoucleurRapide = millisSleepBoucleurRapide;
    }

    public int getMillisSleepBoucleurLent() {
        return millisSleepBoucleurLent;
    }

    public void setMillisSleepBoucleurLent(int millisSleepBoucleurLent) {
        this.millisSleepBoucleurLent = millisSleepBoucleurLent;
    }

    public Timer getTheTimer() {
        return theTimer;
    }

    public void setTheTimer(Timer theTimer) {
        this.theTimer = theTimer;
    }
}
