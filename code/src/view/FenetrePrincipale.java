package view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import launcher.Launcher;
import navigate.Navigator;


import java.io.IOException;

public class FenetrePrincipale {
    private Image img1 = new Image("/img/fullLake.png");
    private Button btnAccueil = new Button("Accueil");

    @FXML
    private BorderPane bigBorderPane;

    @FXML
    private ImageView imgView1;

    @FXML
    private Canvas painting;

    @FXML
    private SubScene sceneTime;

    @FXML
    public void initialize() throws IOException { //pour les contrôleurs utiliser initialize() au lieu du constructeur
        imgView1.setFitHeight(500);
        imgView1.setFitWidth(500);
        imgView1.setImage(img1);

        bigBorderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Navigator nav = Launcher.nav;
        /*
        Box boxOnTheRight = new Box(100, 100, 100);
        boxOnTheRight.setManaged(false);
        bigBorderPane.setRight(boxOnTheRight);
        boxOnTheRight.setTranslateX(600);
        boxOnTheRight.setTranslateY(100);
        */
        bigBorderPane.setRight(btnAccueil);
        btnAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                nav.changeScene("vueAccueil");
            }
        });
    }

    @FXML
    public void clicBtnBleu(ActionEvent actionEvent) {
        GraphicsContext gc = painting.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,100,100);
    }

    @FXML
    public void clicBtnRouge(ActionEvent actionEvent) {
        GraphicsContext gc = painting.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.fillRect(0,0,100,100);
    }

    @FXML
    public void clicBtnVert(ActionEvent actionEvent) {
        GraphicsContext gc = painting.getGraphicsContext2D();

        gc.setFill(Color.GREEN);
        gc.fillRect(0,0,100,100);
    }

    @FXML
    public void clicBtnJaune(ActionEvent actionEvent) {
        GraphicsContext gc = painting.getGraphicsContext2D();

        gc.setFill(Color.YELLOW);
        gc.fillRect(0,0,100,100);
    }
}
