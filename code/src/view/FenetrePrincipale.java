package view;

import fxtimer.FXTimer;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import launcher.Launcher;
import navigate.Navigator;


import java.io.IOException;

public class FenetrePrincipale {
    private Image img1 = new Image("/img/fullLake.png");
    private FXTimer timer = new FXTimer();
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
        imgView1.setFitHeight(750);
        imgView1.setFitWidth(750);
        imgView1.setImage(img1);
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
