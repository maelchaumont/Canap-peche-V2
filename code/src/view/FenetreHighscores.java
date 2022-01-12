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


public class FenetreHighscores {
    public GameManager gM;

    @FXML
    private BorderPane bigBorderPane;

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
        theVBox.setSpacing(10);
        ArrayList<Text> hS = new ArrayList<>();
        ArrayList<Text> placeNameAndScore = new ArrayList<>();
        for(int i=0; i<5; i++) {
            hS.add(new Text(i + " - "));
            placeNameAndScore.add(new Text());
        }
        int iter = 0;
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
            t.setFill(Color.WHITE);
            t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            iter++;
        }
        iter = 0;
        for (Text t : placeNameAndScore) {
            theVBox.getChildren().add(t);
            placeNameAndScore.get(iter).setText(gM.gethS().getMapHighScores().toString());
            t.setFill(Color.WHITE);
            t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            iter++;
        }

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
