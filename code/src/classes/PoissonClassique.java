package classes;

import javafx.scene.image.Image;

public class PoissonClassique extends Poisson{

    public PoissonClassique(int poids, int valeur) {
        super(new Image("img/fish.png"), poids, valeur);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
