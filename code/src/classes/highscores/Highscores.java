package classes.highscores;

import java.util.Map;

public class Highscores {
    private Map<String, Integer> mapHighScores;
    private SauvegardeurHS sHS;
    private ChargeurHS cHS;

    //CONSTRUCTEUR
    public Highscores(SauvegardeurHS sHS, ChargeurHS cHS) {
        this.sHS = sHS;
        this.cHS = cHS;
        this.mapHighScores = cHS.chargeHS();
    }


    //GETTERS & SETTERS
    public Map<String, Integer> getMapHighScores() {
        return mapHighScores;
    }

    public void setMapHighScores(Map<String, Integer> mapHighScores) {
        this.mapHighScores = mapHighScores;
    }

    public SauvegardeurHS getsHS() {
        return sHS;
    }

    public void setsHS(SauvegardeurHS sHS) {
        this.sHS = sHS;
    }

    public ChargeurHS getcHS() {
        return cHS;
    }

    public void setcHS(ChargeurHS cHS) {
        this.cHS = cHS;
    }
}
