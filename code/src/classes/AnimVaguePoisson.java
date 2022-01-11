package classes;

public class AnimVaguePoisson extends Observateur{
    private String etatVaguePoisson;
    private VaguePoissons maVaguePoisson;

    public AnimVaguePoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {
        //test
        for (Poisson p:
             getMaVaguePoisson().getListPoissons()) {
            if(!p.isCatched())
                p.getDeplaceurPoisson().deplacer(p);
        }
    }


    //GETTERS & SETTERS
    public String getEtatVaguePoisson() {
        return etatVaguePoisson;
    }

    public void setEtatVaguePoisson(String etatVaguePoisson) {
        this.etatVaguePoisson = etatVaguePoisson;
    }

    public VaguePoissons getMaVaguePoisson() {
        return maVaguePoisson;
    }

    public void setMaVaguePoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }
}
