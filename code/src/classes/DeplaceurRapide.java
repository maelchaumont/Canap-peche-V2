package classes;

import java.util.Random;

public class DeplaceurRapide extends Deplaceur{

    @Override
    public void deplacer(Poisson p) {
        Random r = new Random();
        int firstMovementIsUp = r.nextInt(2);

        p.setCooXPoisson(p.getCooXPoisson()+10);
        if(firstMovementIsUp == 0)
            p.setCooYPoisson(p.getCooYPoisson()+10);
        else
            p.setCooYPoisson(p.getCooYPoisson()-10);
    }
}
