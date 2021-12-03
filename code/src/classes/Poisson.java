package classes;

public class Poisson {
    private int taille;
    private int valeur;

    //constructeur
    public Poisson(int taille, int valeur) {
        this.taille = taille;
        this.valeur = valeur;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
