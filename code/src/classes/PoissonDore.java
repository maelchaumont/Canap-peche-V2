package classes;

import javafx.scene.image.Image;

public class PoissonDore extends Poisson{
    public PoissonDore(int poids, int valeur) {
        super(new Image("img/poissondore.png"), poids, valeur + 50);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
