package classes.highscores;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Highscores {
    private Map<Integer, String> mapHighScores;
    private SauvegardeurHS sHS;
    private ChargeurHS cHS;

    //CONSTRUCTEUR
    public Highscores(SauvegardeurHS sHS, ChargeurHS cHS) throws IOException {
        String filename= "rsrc/data/dataHighscores.txt";
        File theFile = new File(filename);
        if(!theFile.exists())
            theFile.createNewFile();

        this.sHS = sHS;
        this.cHS = cHS;
        this.mapHighScores = cHS.chargeHS();
    }


    //GETTERS & SETTERS
    public Map<Integer, String> getMapHighScores() {
        return mapHighScores;
    }

    public void setMapHighScores(Map<Integer, String> mapHighScores) {
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
