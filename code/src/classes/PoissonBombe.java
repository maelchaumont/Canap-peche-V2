package classes;

public class PoissonBombe extends Poisson{
    public PoissonBombe(int poids, int valeur) {
        super(poids, valeur - 50);
    }
}
