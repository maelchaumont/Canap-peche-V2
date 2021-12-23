package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import launcher.Launcher;
import navigate.Navigator;

import javax.swing.text.html.HTML;


public class FenetreAccueil {
    private Image imgBackAccueil = new Image("/img/gifBackAccueil");
    private ImageView backgroundAccueil = new ImageView();
    private Button btnJouer = new Button("Jouer");
    private Button btnHS = new Button("Highscores");
    private VBox vboxButtons = new VBox(20);




    @FXML
    private BorderPane borderPaneAccueil;


    @FXML
    public void initialize() {
        borderPaneAccueil.setCenter(backgroundAccueil);
        backgroundAccueil.setFitHeight(500);
        backgroundAccueil.setFitWidth(500);
        backgroundAccueil.setImage(imgBackAccueil);
        borderPaneAccueil.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        vboxButtons.setAlignment(Pos.CENTER);
        vboxButtons.setTranslateX(50);
        vboxButtons.setTranslateY(50);
        btnJouer.setMinWidth(50);
        btnHS.setMinWidth(75);
        vboxButtons.getChildren().add(btnJouer);
        vboxButtons.getChildren().add(btnHS);
        borderPaneAccueil.getChildren().add(vboxButtons);

        Navigator nav = Launcher.nav;
        btnJouer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                nav.changeScene("vuePrincipale");
            }
        });
    }

}
