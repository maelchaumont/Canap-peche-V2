package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import classes.GameManager;

import java.io.IOException;


public class FenetreHighscores {
    public GameManager gM;

    @FXML
    private BorderPane bigBorderPane;

    @FXML
    private VBox theVBox;
    @FXML
    private Text hSno1;
    @FXML
    private Text hSno2;
    @FXML
    private Text hSno3;
    @FXML
    private Text hSno4;
    @FXML
    private Text hSno5;
    @FXML
    private Text placeNameAndScore1;
    @FXML
    private Text placeNameAndScore2;
    @FXML
    private Text placeNameAndScore3;
    @FXML
    private Text placeNameAndScore4;
    @FXML
    private Text placeNameAndScore5;

    public FenetreHighscores(GameManager gM) {
        this.gM = gM;
    }

    @FXML
    public void initialize() {
        theVBox.setSpacing(10);
        hSno1.setFill(Color.WHITE);
        hSno2.setFill(Color.WHITE);
        hSno3.setFill(Color.WHITE);
        hSno4.setFill(Color.WHITE);
        hSno5.setFill(Color.WHITE);
        hSno1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        hSno2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        hSno3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        hSno4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        hSno5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        placeNameAndScore1.setText(gM.gethS().getMapHighScores().toString());
        //placeNameAndScore1.textProperty().bind(gM.gethS().getMapHighScores().toString());

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double theHeight = screenBounds.getHeight() * (80/100.0);
        double theWidth = screenBounds.getWidth() * (80/100.0);

        bigBorderPane.setMinWidth(theWidth);
        bigBorderPane.setMinHeight(theHeight);

        BackgroundSize bGS = new BackgroundSize(theWidth, theHeight, false, false, false, false);

        Background bG = new Background(new BackgroundImage(new Image("img/trophyBackHS.jpg"),
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT,
                                                            BackgroundPosition.DEFAULT,
                                                            bGS));
        bigBorderPane.setBackground(bG);

        Button btnRetAccueil = new Button("Retour à l'Accueil");
        bigBorderPane.setTop(btnRetAccueil);
        BorderPane.setMargin(btnRetAccueil, new Insets(10)); //recrée l'équivalent de margin: 10px; en CSS
        btnRetAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
                    loader.setController(new FenetreAccueil(gM));
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
