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
import java.util.ArrayList;
import java.util.Map;


public class FenetreHighscores {
    public GameManager gM;

    @FXML
    private BorderPane bigBorderPane;
    @FXML
    private BorderPane otherBorderPane;

    @FXML
    private VBox theVBox;
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;
    @FXML
    private HBox HBox3;
    @FXML
    private HBox HBox4;
    @FXML
    private HBox HBox5;

    public FenetreHighscores(GameManager gM) {
        this.gM = gM;
    }

    @FXML
    public void initialize() {
        bigBorderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double theHeight = screenBounds.getHeight() * (80/100.0);
        double theWidth = screenBounds.getWidth() * (80/100.0);

        bigBorderPane.setMinWidth(theWidth);
        bigBorderPane.setMinHeight(theHeight);

        BackgroundSize bGS = new BackgroundSize(theWidth, theHeight, false, false, false, false);

        Background bG = new Background(new BackgroundImage(new Image("img/trophyBackHS.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bGS));
        otherBorderPane.setBackground(bG);



        theVBox.setSpacing(10);
        ArrayList<Text> hS = new ArrayList<>();
        ArrayList<Text> placeNameAndScore = new ArrayList<>();
        for(int i=1; i<6; i++) {
            Text textHS = new Text(i + " - ");
            Text textNameScore = new Text();
            textHS.getStyleClass().add("verdanaWhiteText");
            textNameScore.getStyleClass().add("verdanaWhiteText");
            hS.add(textHS);
            placeNameAndScore.add(textNameScore);
        }
        int iter = 1;
        for (Text t : hS) {
            HBox varHBox = new HBox();
            switch (iter) {
                case 1 -> varHBox = HBox1;
                case 2 -> varHBox = HBox2;
                case 3 -> varHBox = HBox3;
                case 4 -> varHBox = HBox4;
                case 5 -> varHBox = HBox5;
            }
            varHBox.getChildren().add(t);
            iter++;
        }
        iter = 1;
        for (final Map.Entry<Integer, String> entry : gM.gethS().getMapHighScores().entrySet()) {
            HBox varHBox = new HBox();
            switch (iter) {
                case 1 -> varHBox = HBox1;
                case 2 -> varHBox = HBox2;
                case 3 -> varHBox = HBox3;
                case 4 -> varHBox = HBox4;
                case 5 -> varHBox = HBox5;
            }
            Text t = placeNameAndScore.get(iter-1);
            varHBox.getChildren().add(t);
            t.setText(entry.getValue() + " avec un score de " + entry.getKey());
            iter++;
        }



        Button btnRetAccueil = new Button("Retour à l'Accueil");
        otherBorderPane.setTop(btnRetAccueil);
        BorderPane.setMargin(btnRetAccueil, new Insets(10)); //recrée l'équivalent de margin: 10px; en CSS
        btnRetAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
                    loader.setController(new FenetreAccueil(gM));
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
