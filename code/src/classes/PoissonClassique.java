package classes;

import javafx.scene.image.Image;

public class PoissonClassique extends Poisson{
    public PoissonClassique(int poids, int valeur) {
        super(poids, valeur);
        super.setSpritePoisson(new Image("img/fish.png"));

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
