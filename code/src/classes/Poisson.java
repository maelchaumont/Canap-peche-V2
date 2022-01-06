package classes;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public abstract class Poisson extends Circle {
    private int poids;
    private int valeur;
    private Deplaceur deplaceurPoisson;
    private Image spritePoisson;
    private boolean isCatched;
    private int cooXPoisson;
    private int cooYPoisson;

    //constructeur
    public Poisson(Image image, int poids, int valeur) {
        this.poids = poids;
        this.valeur = valeur;
        isCatched = false;

        //cercle
        super.setRadius(25);
        super.setFill(new ImagePattern(image));

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
        this.setTranslateX(cooXPoisson);
        this.cooXPoisson = cooXPoisson;
    }

    public int getCooYPoisson() {
        return cooYPoisson;
    }

    public void setCooYPoisson(int cooYPoisson) {
        this.setTranslateY(cooYPoisson);
        this.cooYPoisson = cooYPoisson;
    }
}
