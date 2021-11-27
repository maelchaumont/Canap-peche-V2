package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class FenetrePrincipale {

    @FXML
    private Canvas painting;

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
