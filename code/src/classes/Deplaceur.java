package classes;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public abstract class Deplaceur {
    public int multiplier;

    public void deplacer(Node n, int x, int y) {
        n.setTranslateX(x * multiplier);
        n.setTranslateY(y * multiplier);
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
