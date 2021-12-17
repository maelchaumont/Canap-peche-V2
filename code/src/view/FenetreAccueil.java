package view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class FenetreAccueil {
    private Image imgBackAccueil = new Image("/img/gifBackAccueil");

    @FXML
    private ImageView backgroundAccueil;


    @FXML
    public void initialize() throws IOException {
        backgroundAccueil.setFitHeight(750);
        backgroundAccueil.setFitWidth(750);
        backgroundAccueil.setImage(imgBackAccueil);
    }

}
