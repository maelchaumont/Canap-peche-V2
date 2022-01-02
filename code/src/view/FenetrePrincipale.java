package view;

import classes.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import launcher.Launcher;
import manager.GameManager;


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
        VaguePoissons vP = new VaguePoissons(7);
        for (Poisson fish:
             vP.getListPoissons()) {
            bigBorderPane.getChildren().add(fish);
        }
        /*
        Poisson poissontest = new PoissonBombe(49, 57);
        bigBorderPane.getChildren().add(poissontest);
        poissontest.setTranslateX(100);
        poissontest.setTranslateY(100);
        */

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
            //poissontest.setDeplaceurPoisson(new DeplaceurLent());
            //poissontest.getDeplaceurPoisson().deplacer(poissontest, 200, 200);
        });

        bigBorderPane.setRight(btnAccueil);
        //click de l'utilisateur sur le bouton d'accueil
        btnAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent racine = FXMLLoader.load(getClass().getResource("/FXML/FenetreAccueil.fxml"));
                    Stage theStage = (Stage) btnAccueil.getScene().getWindow();
                    theStage.setScene(new Scene(racine));
                    theStage.show();

                    //STATIC A EVITER
                    //GameManager.myStage.setScene(new Scene(racine));
                    //GameManager.myStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
