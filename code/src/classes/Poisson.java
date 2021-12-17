package classes;

import javafx.scene.image.Image;

public abstract class Poisson {
    private int poids;
    private int valeur;
    private Deplaceur deplaceurPoisson;
    private Image spritePoisson;
    private boolean isCatched;
    private int cooXPoisson;
    private int cooYPoisson;

    //constructeur
    public Poisson(int poids, int valeur) {
        this.poids = poids;
        this.valeur = valeur;
        isCatched = false;
        //temporaire
        cooXPoisson = 0;
        cooYPoisson = 0;
    }


    //getters et setters

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

    public Image getSpritePoisson() {
        return spritePoisson;
    }

    public void setSpritePoisson(Image spritePoisson) {
        this.spritePoisson = spritePoisson;
    }

    public boolean isCatched() {
        return isCatched;
    }

    public void setCatched(boolean catched) {
        isCatched = catched;
    }

    public int getCooXPoisson() {
        return cooXPoisson;
    }

    public void setCooXPoisson(int cooXPoisson) {
        this.cooXPoisson = cooXPoisson;
    }

    public int getCooYPoisson() {
        return cooYPoisson;
    }

    public void setCooYPoisson(int cooYPoisson) {
        this.cooYPoisson = cooYPoisson;
    }
}
