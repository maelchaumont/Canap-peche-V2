package classes;

import java.util.Random;

public class DeplaceurLent extends Deplaceur{

    @Override
    public void deplacer(Poisson p) {
        Random r = new Random();
        int firstMovementIsUp = r.nextInt(2);

        p.setTranslateX(p.getTranslateX()+5);
        if(firstMovementIsUp == 0)
            p.setTranslateY(p.getTranslateY()+5);
        else
            p.setTranslateY(p.getTranslateY()-5);
    }
}
