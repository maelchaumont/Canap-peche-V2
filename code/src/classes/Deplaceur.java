package classes;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public abstract class Deplaceur {
    public int multiplier;

    public void deplacer(Poisson p, int x, int y) {
        p.setTranslateX(x * multiplier);
        p.setTranslateY(y * multiplier);
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
