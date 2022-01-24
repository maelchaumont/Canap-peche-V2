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
    private final int millisSleepBoucleurRapide;
    private final int millisSleepBoucleurLent;
    private Timer theTimer;
    private Thread thread1;
    private Thread thread2;

    public GameManager(Stage myStage) {
        this.myStage = myStage;
        vP = new VaguePoissons(7);
        try {
            hS = new Highscores(new SauvegardeurHS(), new ChargeurHS());
            System.out.println(hS.getMapHighScores().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        millisSleepBoucleurRapide = 25; //25 millissec
        millisSleepBoucleurLent = 7000; //7s sec
    }



    public void startNewGame() {
        vP = new VaguePoissons(7);
        lePecheur.setScorePecheur(0);
        BoucleurRapide boucleurRapide = new BoucleurRapide(millisSleepBoucleurRapide, vP, this);
        BoucleurLent boucleurLent = new BoucleurLent(millisSleepBoucleurLent, vP);
        thread1 = new Thread(boucleurRapide);
        thread2 = new Thread(boucleurLent);
        thread1.start();
        thread2.start();
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

    public Timer getTheTimer() {
        return theTimer;
    }

    public void setTheTimer(Timer theTimer) {
        this.theTimer = theTimer;
    }

    public Thread getThread1() {
        return thread1;
    }

    public void setThread1(Thread thread1) {
        this.thread1 = thread1;
    }

    public Thread getThread2() {
        return thread2;
    }

    public void setThread2(Thread thread2) {
        this.thread2 = thread2;
    }
}
