package classes;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Poisson implements Observable {
    private int poids;
    private int valeur;
    private Deplaceur deplaceurPoisson;
    private Image spritePoisson;
    private boolean isCatched;
    private Circle circleClick;

    //constructeur
    public Poisson(Image spritePoisson, int poids, int valeur) {
        this.poids = poids;
        this.valeur = valeur;
        this.spritePoisson = spritePoisson;
        circleClick = new Circle();
        circleClick.setRadius(50);
        circleClick.setFill(Color.TRANSPARENT);
        circleClick.setStroke(Color.TRANSPARENT);
        circleClick.translateXProperty().bind(this.cooXPoissonProperty().add(30));
        circleClick.translateYProperty().bind(this.cooYPoissonProperty().add(25));
        isCatched = false;
    }


    //binding
    private IntegerProperty cooXPoisson = new SimpleIntegerProperty();
        public Integer getCooXPoisson(){return cooXPoisson.get();}
        public void setCooXPoisson(int nvCoo){cooXPoisson.set(nvCoo);}
        public ReadOnlyIntegerProperty cooXPoissonProperty(){return cooXPoisson;}

    private IntegerProperty cooYPoisson = new SimpleIntegerProperty();
        public Integer getCooYPoisson(){return cooYPoisson.get();}
        public void setCooYPoisson(int nvCoo){cooYPoisson.set(nvCoo);}
        public ReadOnlyIntegerProperty cooYPoissonProperty(){return cooYPoisson;}




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

    public Circle getCircleClick() {
        return circleClick;
    }

    public void setCircleClick(Circle circleClick) {
        this.circleClick = circleClick;
    }


    //A ENLEVER
    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
