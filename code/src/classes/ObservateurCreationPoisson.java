package classes;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ObservateurCreationPoisson extends Observateur{
    private VaguePoissons maVaguePoisson;

    public ObservateurCreationPoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {
        VaguePoissons nvVague = new VaguePoissons(7);
        maVaguePoisson.setNbPoissons(maVaguePoisson.getNbPoissons()+nvVague.getNbPoissons());
        for (Poisson p:
                nvVague.getListPoissons()) {
            maVaguePoisson.getListPoissons().add(p);
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
