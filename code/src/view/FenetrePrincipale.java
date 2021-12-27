package view;

import classes.DeplaceurLent;
import classes.Poisson;
import classes.PoissonBombe;
import classes.PoissonClassique;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
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
import javafx.scene.shape.Circle;
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
    private TextField textFieldTest;

    @FXML
    public void initialize() throws IOException { //pour les contrôleurs utiliser initialize() au lieu du constructeur
        imgView1.setFitHeight(500);
        imgView1.setFitWidth(500);
        imgView1.setImage(img1);

        bigBorderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Poisson poissontest = new PoissonClassique(49, 57);
        bigBorderPane.getChildren().add(poissontest);
        poissontest.setTranslateX(100);
        poissontest.setTranslateY(100);


        //STATIC A CHANGER
        Navigator nav = Launcher.nav;

        //click de l'utilisateur n'importe où
        bigBorderPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            double x = event.getSceneX();
            double y = event.getSceneY();
            textFieldTest.setText("Rentre dans le handler. coo :"+ x + "," + y);
            textFieldTest.prefColumnCountProperty().bind(textFieldTest.textProperty().length());;

            //test de l'emplacement du click
            Circle circletest = new Circle();
            bigBorderPane.getChildren().add(circletest);
            circletest.setRadius(15);
            circletest.setFill(Color.WHITE);
            circletest.setCenterX(x);
            circletest.setCenterY(y);

            //Déplacement du poisson à des coo fixes(instantanément...)
            poissontest.setDeplaceurPoisson(new DeplaceurLent());
            poissontest.getDeplaceurPoisson().deplacer(poissontest, 200, 200);
        });

        bigBorderPane.setRight(btnAccueil);
        //click de l'utilisateur sur le bouton d'accueil
        btnAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                nav.changeScene("vueAccueil");
            }
        });
    }
}
