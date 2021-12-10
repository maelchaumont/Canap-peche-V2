package classes;

public abstract class Poisson {
    private int poids;
    private int valeur;
    private Deplaceur deplaceurPoisson;

    //constructeur
    public Poisson(int poids, int valeur) {
        this.poids = poids;
        this.valeur = valeur;
    }


    public Deplaceur getDeplaceurPoisson() {
        return deplaceurPoisson;
    }

    public void setDeplaceurPoisson(Deplaceur deplaceurPoisson) {
        this.deplaceurPoisson = deplaceurPoisson;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
