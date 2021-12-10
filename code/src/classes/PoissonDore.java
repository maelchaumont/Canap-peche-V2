package classes;

public class PoissonDore extends Poisson{
    public PoissonDore(int poids, int valeur) {
        super(poids, valeur + 50);
    }
}
