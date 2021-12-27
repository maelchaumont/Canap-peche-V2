package classes;

import java.util.ArrayList;
import java.util.List;

public class Pecheur {
    private String pseudo;
    private int score;
    private ArrayList<Poisson> listPoissonsAttrapes;

    //constructeur
    public Pecheur(String pseudo, int score) {
        this.pseudo = pseudo;
        this.score = score;
        listPoissonsAttrapes = new ArrayList<Poisson>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
