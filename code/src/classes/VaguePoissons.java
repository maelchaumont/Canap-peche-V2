package classes;

import java.util.ArrayList;
import java.util.List;

public class VaguePoissons {
    private ArrayList<Poisson> listPoissons;
    private int nbPoissons;


    public VaguePoissons(ArrayList<Poisson> listPoissons, int nbPoissons) {
        this.listPoissons = listPoissons;
        this.nbPoissons = nbPoissons;
    }

    public List<Poisson> getListPoissons() {
        return listPoissons;
    }

    public void setListPoissons(ArrayList<Poisson> listPoissons) {
        this.listPoissons = listPoissons;
    }

    public int getNbPoissons() {
        return nbPoissons;
    }

    public void setNbPoissons(int nbPoissons) {
        this.nbPoissons = nbPoissons;
    }
}
