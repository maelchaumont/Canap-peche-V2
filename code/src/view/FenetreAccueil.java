package view;

import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import launcher.Launcher;
import manager.GameManager;

import java.io.IOException;


public class FenetreAccueil {
    private Image imgBackAccueil = new Image("/img/gifBackAccueil");
    private ImageView backgroundAccueil = new ImageView();
    private Button btnJouer = new Button("Jouer");
    private Button btnHS = new Button("Highscores");
    private VBox vboxButtons = new VBox(20);
    private StackPane stackPaneCenter = new StackPane();
    private GameManager gM;



    @FXML
    private BorderPane borderPaneAccueil;

    public FenetreAccueil(GameManager gM) {
        this.gM = gM;
    }


    @FXML
    public void initialize() {
        stackPaneCenter.getChildren().addAll(vboxButtons, backgroundAccueil);

        borderPaneAccueil.setCenter(stackPaneCenter);
        backgroundAccueil.setFitHeight(800);
        backgroundAccueil.setFitWidth(800);
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


        //HANDLERS BUTTONS
        btnJouer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
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
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
                    loader.setController(new FenetrePrincipale(gM));
                    Parent root = loader.load();
                    theStage.setScene(new Scene(root));
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
                    theStage.setScene(new Scene(root));
                    theStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
