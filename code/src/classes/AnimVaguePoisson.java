package classes;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.util.ArrayList;

public class AnimVaguePoisson extends Observateur{
    private VaguePoissons maVaguePoisson;
   //private GameManager gM;

    public AnimVaguePoisson(VaguePoissons maVaguePoisson, GameManager gM) {
        //this.gM = gM;
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double endOfScreen = screenBounds.getMaxX()-150;

        VaguePoissons maVaguePoissonUpdated = getMaVaguePoisson();
        ArrayList<Poisson> listFishtoRemove = new ArrayList<Poisson>();
        for (Poisson p:
             getMaVaguePoisson().getListPoissons()) {
            if(!p.isCatched())
                p.getDeplaceurPoisson().deplacer(p);
            /*
            if(p.getCooXPoisson() >= endOfScreen)
                listFishtoRemove.add(p);
             */
        }

        /*
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (Poisson p:
                     listFishtoRemove) {
                    maVaguePoissonUpdated.getListPoissons().remove(p);
                    gM.getvP().getListPoissons().remove(p);
                }
                setMaVaguePoisson(maVaguePoissonUpdated);
            }
        });
        */
    }


    //GETTERS & SETTERS
    public VaguePoissons getMaVaguePoisson() {
        return maVaguePoisson;
    }

    public void setMaVaguePoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }
}
