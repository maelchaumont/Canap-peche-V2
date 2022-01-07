package classes;

public class AnimVaguePoisson extends Observateur{
    private String etatVaguePoisson;
    private VaguePoissons maVaguePoisson;

    @Override
    public void update() {
        maVaguePoisson = new VaguePoissons(7);
        //etatVaguePoisson = maVaguePoisson.getEtatVague();

        //test
        for (Poisson p:
             getMaVaguePoisson().getListPoissons()) {
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
