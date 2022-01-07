package classes;

import java.util.Random;

public class DeplaceurLent extends Deplaceur{

    @Override
    public void deplacer(Poisson p) {
        Random r = new Random();
        int firstMovementIsUp = r.nextInt(2);

        p.setCooXPoisson(p.getCooXPoisson()+5);
        if(firstMovementIsUp == 0)
            p.setCooYPoisson(p.getCooYPoisson()+5);
        else
            p.setCooYPoisson(p.getCooYPoisson()-5);
    }
}
