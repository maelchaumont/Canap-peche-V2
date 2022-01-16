package view;

import classes.GameManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class FenetreGameOver {
    private GameManager gM;

    public FenetreGameOver(GameManager gM) {
        this.gM = gM;
    }

    @FXML
    private BorderPane bigBorderPane;
    @FXML
    private Button btnReplay;
    @FXML
    private Button btnBackToAccueil;

    @FXML
    public void initialize() {
        bigBorderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //HANDLERS BUTTONS
        btnReplay.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
                    loader.setController(new FenetrePrincipale(gM));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);
                    newScene.getStylesheets().add("css/styles.css");
                    Image theCursorImage = new Image("/img/bouchonPeche.png");
                    newScene.setCursor(new ImageCursor(theCursorImage, theCursorImage.getWidth(), theCursorImage.getHeight()));
                    theStage.setScene(newScene);
                    theStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBackToAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
                    loader.setController(new FenetreAccueil(gM));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);
                    newScene.getStylesheets().add("css/styles.css");
                    theStage.setScene(newScene);
                    theStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
