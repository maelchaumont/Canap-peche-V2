package classes;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Poisson implements Observable {
    private int poids;
    private int valeur;
    private Deplaceur deplaceurPoisson;
    private boolean isCatched;
    private Circle circleClick;

    //constructeur
    public Poisson(Image myImage, int poids, int valeur) {
        this.poids = poids;
        this.valeur = valeur;
        setSpritePoisson(myImage);
        setHeightSprite(50);
        setWidthSprite(60);
        circleClick = new Circle();
        circleClick.setRadius(50);
        circleClick.setFill(Color.TRANSPARENT);
        circleClick.setStroke(Color.TRANSPARENT);
        circleClick.translateXProperty().bind(this.cooXPoissonProperty().add(30));
        circleClick.translateYProperty().bind(this.cooYPoissonProperty().add(25));
        isCatched = false;
    }


    //binding
    private ObjectProperty<Image> spritePoisson = new SimpleObjectProperty<>();
    public Image getSpritePoisson(){return spritePoisson.get();}
    public void setSpritePoisson(Image nvImage){spritePoisson.set(nvImage);}
    public ObjectProperty<Image> spritePoissonProperty(){return spritePoisson;}

    private DoubleProperty heightSprite = new SimpleDoubleProperty();
    public double getHeightSprite(){return heightSprite.get();}
    public void setHeightSprite(double nvHeight){heightSprite.set(nvHeight);}
    public ReadOnlyDoubleProperty heightSpriteProperty(){return heightSprite;}

    private DoubleProperty widthSprite = new SimpleDoubleProperty();
    public double getWidthSprite(){return widthSprite.get();}
    public void setWidthSprite(double nvWidth){widthSprite.set(nvWidth);}
    public ReadOnlyDoubleProperty widthSpriteProperty(){return widthSprite;}

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
