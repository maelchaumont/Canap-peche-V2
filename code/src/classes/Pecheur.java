package classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class Pecheur {
    private String pseudo;
    private ArrayList<Poisson> listPoissonsAttrapes;

    //constructeur
    public Pecheur(String pseudo) {
        this.pseudo = pseudo;
        this.setScorePecheur(0);
        listPoissonsAttrapes = new ArrayList<Poisson>();
    }


    //binding
    private IntegerProperty scorePecheur = new SimpleIntegerProperty();
    public Integer getScorePecheur(){return scorePecheur.get();}
    public void setScorePecheur(int nvScore){scorePecheur.set(nvScore);}
    public ReadOnlyIntegerProperty scorePecheurProperty(){return scorePecheur;}

    //GETTERS & SETTERS
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<Poisson> getListPoissonsAttrapes() {
        return listPoissonsAttrapes;
    }

    public void setListPoissonsAttrapes(ArrayList<Poisson> listPoissonsAttrapes) {
        this.listPoissonsAttrapes = listPoissonsAttrapes;
    }
}
