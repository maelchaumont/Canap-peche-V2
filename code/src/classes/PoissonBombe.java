package classes;

import javafx.scene.image.Image;

import java.util.Random;

public class PoissonBombe extends Poisson{
    public PoissonBombe(int poids, int valeur) {
        super(new Image("img/poissonbombe.png"), poids, valeur - 50);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
