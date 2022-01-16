package classes;

import java.util.Random;

public class DeplaceurLent extends Deplaceur{

    @Override
    public void deplacer(Poisson p) {
        Random r = new Random();
        int firstMovementIsUp = r.nextInt(2);
        p.setCooXPoisson(p.getCooXPoisson()+5);

        //ou si le poisson est trop haut ou trop bas sur l'écran
        if((firstMovementIsUp == 0 || p.getCooYPoisson() <= 100) &&  p.getCooYPoisson() <= 700)
            p.setCooYPoisson(p.getCooYPoisson()+5);
        else
            p.setCooYPoisson(p.getCooYPoisson()-5);
    }
}
