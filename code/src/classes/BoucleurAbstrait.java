package classes;

import java.util.ArrayList;

public abstract class BoucleurAbstrait {
    private ArrayList<Poisson> listObservateursPoissons;

    public BoucleurAbstrait() {
        this.listObservateursPoissons = new ArrayList<>();
    }

    public void beep() {
        for (Poisson p :
             this.getListObservateursPoissons()) {
            p.update();
        }
    }

    public void attacher(Poisson p) {
        listObservateursPoissons.add(p);
    }

    public void decrocher(Poisson p) {
        listObservateursPoissons.remove(p);
    }


    //GETTERS
    public ArrayList<Poisson> getListObservateursPoissons() {
        return listObservateursPoissons;
    }
}
