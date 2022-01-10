package view;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import manager.GameManager;


public class FenetreHighscores {
    public GameManager gM;

    @FXML
    private BorderPane bigBorderPane;

    public FenetreHighscores(GameManager gM) {
        this.gM = gM;
    }

    @FXML
    public void initialize() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double theHeight = screenBounds.getHeight();
        double theWidth = screenBounds.getWidth();

        bigBorderPane.setMinWidth(theWidth);
        bigBorderPane.setMinHeight(theHeight);

        BackgroundSize bGS = new BackgroundSize(theWidth, theHeight, false, false, false, false);

        Background bG = new Background(new BackgroundImage(new Image("img/trophyBackHS.jpg"),
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundPosition.DEFAULT,
                                                            bGS));
        bigBorderPane.setBackground(bG);
    }
}
