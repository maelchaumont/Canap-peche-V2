package view;

import fxtimer.FXTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class FenetrePrincipale {
    private Image img1 = new Image("/img/fullLake.png");
    private FXTimer timer = new FXTimer();

    @FXML
    private BorderPane bigBorderPane;

    @FXML
    private ImageView imgView1;

    @FXML
    private Canvas painting;

    @FXML
    private TextField chronometer;

    @FXML
    public void initialize() { //pour les contrôleurs utiliser initialize() au lieu du constructeur
        imgView1.setImage(img1);
        //Parent root = new FXTimer();
        //realChronometer = new SubScene(root, 100, 100);
        Box boxOnTheRight = new Box(100, 100, 100);
        boxOnTheRight.setManaged(false);
        bigBorderPane.setRight(boxOnTheRight);
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
