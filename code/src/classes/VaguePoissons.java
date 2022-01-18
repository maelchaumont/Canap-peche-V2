package classes;


import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class VaguePoissons {
    private int nbPoissons;


    //CONSTRUCTEUR
    public VaguePoissons(int nbPoissons) {
        this.nbPoissons = nbPoissons;

        Random r = new Random();
        int low = 5;
        int high = 25;
        //5 poissons ou +
        if(getNbPoissons() > 5) {
            for (int i = 0; i < nbPoissons-2; i++) {
                int valeur = r.nextInt(high-low) + low;
                listPoissons.add(new PoissonClassique(valeur));
            }
            listPoissons.add(new PoissonBombe(0)); //-50 rajouté dans le constructeur de PoissonBombe
            listPoissons.add(new PoissonDore(0)); //+50 rajouté dans le constructeur de PoissonDore
        }
        // - de 5 poissons
        else {
            for (int i = 0; i < nbPoissons; i++) {
                int valeur = r.nextInt(high-low) + low;
                listPoissons.add(new PoissonClassique(valeur));
            }
        }

        //positionnement de chaque Poisson de la vague à des coo aléatoires
        for (Poisson p:
             getListPoissons()) {
            Random rCooY = new Random();
            int lowY = 150;
            int highY = 550;
            p.setCooXPoisson(15);
            p.setCooYPoisson(rCooY.nextInt(highY-lowY) + lowY);
        }
    }


    //GETTERS ET SETTERS
    ObservableList<Poisson> observableListPoissons = FXCollections.observableArrayList();
    ListProperty<Poisson> listPoissons = new SimpleListProperty<Poisson>(observableListPoissons);
    public ObservableList<Poisson> getListPoissons(){return listPoissons.get();}
    public void setListPoissons(SimpleListProperty<Poisson> nvListe){listPoissons.set(nvListe);}
    public ReadOnlyListProperty<Poisson> listPoissonsProperty(){return listPoissons;}

    public int getNbPoissons() {
        return nbPoissons;
    }
    public void setNbPoissons(int nbPoissons) {
        this.nbPoissons = nbPoissons;
    }
}
