package classes;

import javafx.scene.image.Image;

public class PoissonDore extends Poisson{
    public PoissonDore(int valeur) {
        super(new Image("img/poissondore.png"), valeur + 50);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
