package controleurs;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import classes.GameManager;

import java.io.IOException;


public class FenetreAccueil {
    private Image imgBackAccueil = new Image("/img/gifBackAccueil");
    private Button btnTutoJouer = new Button("Tutoriel + Jouer");
    private Button btnHS = new Button("Highscores");
    private VBox vboxButtons = new VBox(20);
    private GameManager gM;



    @FXML
    private BorderPane borderPaneAccueil;
    @FXML
    private BorderPane borderPaneCenter;

    public FenetreAccueil(GameManager gM) {
        this.gM = gM;
    }


    @FXML
    public void initialize() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double theHeight = screenBounds.getHeight() * (80/100.0);
        double theWidth = screenBounds.getWidth() * (80/100.0);
        borderPaneAccueil.setPrefHeight(theHeight);
        borderPaneAccueil.setPrefWidth(theWidth);

        borderPaneAccueil.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        BackgroundSize bGS = new BackgroundSize(theWidth, theHeight, false, false, false, false);
        Background bGC = new Background(new BackgroundImage(new Image("img/gifBackAccueil"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bGS));
        borderPaneCenter.setBackground(bGC);

        vboxButtons.setAlignment(Pos.CENTER);
        btnTutoJouer.setMinWidth(50);
        btnHS.setMinWidth(75);
        vboxButtons.getChildren().add(btnTutoJouer);
        vboxButtons.getChildren().add(btnHS);
        borderPaneCenter.setCenter(vboxButtons);


        //HANDLERS BUTTONS
        btnTutoJouer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    /*
                    Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
                    Stage theStage = (Stage) btnJouer.getScene().getWindow();
                    theStage.setScene(new Scene(racine));
                    theStage.show();
                     */
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreLogEtTuto.fxml"));
                    loader.setController(new FenetreLogEtTuto(gM));
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

        btnHS.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreHighscores.fxml"));
                    loader.setController(new FenetreHighscores(gM));
                    Parent root = loader.load();
                    Scene theScene = new Scene(root);
                    theScene.getStylesheets().add("css/styles.css");
                    theStage.setScene(theScene);
                    theStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
