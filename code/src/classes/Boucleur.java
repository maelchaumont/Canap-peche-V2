package classes;

public class Boucleur implements Runnable{
    @Override
    public void run(){
        while(true) {
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.tourDeBoucle();
            //dire qu'on beep
        }
    }

    public void tourDeBoucle(){
        //vP doit pas être dans le boucleur
        VaguePoissons vP = new VaguePoissons(7);
        /*
        for (Poisson p:
             super.getListObservateursPoissons()) {
            p.getDeplaceurPoisson().deplacer(p);
        }
        */
    }
}
