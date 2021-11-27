package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class FenetrePrincipale {
    @FXML
    private Button btnBleu;
    private Canvas painting;

    @FXML
    public void clicBtnBleu(ActionEvent actionEvent) {
        GraphicsContext gc = painting.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.fillRect(75,75,100,100);
    }
}
