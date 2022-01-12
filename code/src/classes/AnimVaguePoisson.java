package classes;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class AnimVaguePoisson extends Observateur{
    private VaguePoissons maVaguePoisson;

    public AnimVaguePoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double endOfScreen = screenBounds.getMaxX();

        for (Poisson p:
             getMaVaguePoisson().getListPoissons()) {
            if(!p.isCatched())
                p.getDeplaceurPoisson().deplacer(p);
            //if(p.getCooXPoisson() >= endOfScreen)
        }
    }


    //GETTERS & SETTERS
    public VaguePoissons getMaVaguePoisson() {
        return maVaguePoisson;
    }

    public void setMaVaguePoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }
}
