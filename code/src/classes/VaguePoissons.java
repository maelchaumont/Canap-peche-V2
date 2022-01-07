package classes;

import java.util.ArrayList;
import java.util.Random;

public class VaguePoissons {
    private ArrayList<Poisson> listPoissons;
    private int nbPoissons;


    public VaguePoissons(int nbPoissons) {

        this.nbPoissons = nbPoissons;
        listPoissons = new ArrayList<>();

        Random r = new Random();
        int low = 5;
        int high = 25;
        //5 poissons ou +
        if(nbPoissons > 5) {
            for (int i = 0; i < nbPoissons-2; i++) {
                int poids = r.nextInt(high-low) + low;
                listPoissons.add(new PoissonClassique(poids,10));
            }
            int poids = r.nextInt(high-low) + low;
            listPoissons.add(new PoissonBombe(poids,0));
            poids = r.nextInt(high-low) + low;
            listPoissons.add(new PoissonDore(poids,0));
        }
        // - de 5 poissons
        else {
            for (int i = 0; i < nbPoissons; i++) {
                int poids = r.nextInt(high-low) + low;
                listPoissons.add(new PoissonClassique(poids,10));
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
    public ArrayList<Poisson> getListPoissons() {
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
