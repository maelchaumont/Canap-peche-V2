package view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class FenetreAccueil {
    private Image imgBackAccueil = new Image("/img/gifBackAccueil");
    private ImageView backgroundAccueil = new ImageView();


    @FXML
    private BorderPane borderPaneAccueil;


    @FXML
    public void initialize() {
        borderPaneAccueil.setCenter(backgroundAccueil);
        backgroundAccueil.setFitHeight(750);
        backgroundAccueil.setFitWidth(750);
        backgroundAccueil.setImage(imgBackAccueil);
    }

}
