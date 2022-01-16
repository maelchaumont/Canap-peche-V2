package view;

import classes.*;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import classes.GameManager;
import javafx.stage.Stage;


import java.io.IOException;

public class FenetrePrincipale {
    private Image img1 = new Image("/img/fullLake.png");
    private Button btnAccueil = new Button("Accueil");
    private GameManager gM;

    @FXML
    private BorderPane bigBorderPane;

    @FXML
    private Text timeDisplay;

    @FXML
    private Text statsPseudo;

    @FXML
    private Text statsScore;

    @FXML
    private ImageView imgView1;

    @FXML
    private TextField textFieldTest;

    public FenetrePrincipale(GameManager gM) {
        this.gM = gM;
    }

    @FXML
    public void initialize() throws IOException { //pour les contrôleurs utiliser initialize() au lieu du constructeur
        //début d'une nouvelle partie
        gM.startNewGame();

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double theHeight = screenBounds.getHeight() * (80/100.0);
        double theWidth = screenBounds.getWidth() * (80/100.0);
        bigBorderPane.setPrefHeight(theHeight);
        bigBorderPane.setPrefWidth(theWidth);
        imgView1.setFitHeight(theHeight);
        imgView1.setFitWidth(theWidth);
        imgView1.setImage(img1);

        timeDisplay.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        timeDisplay.textProperty().bind(gM.getTheTimer().actualTimeProperty().asString());
        statsPseudo.setText(gM.getLePecheur().getPseudo());
        statsScore.textProperty().bind(gM.getLePecheur().scorePecheurProperty().asString());

        bigBorderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        gM.getvP().getListPoissons().addListener(new ListChangeListener<Poisson>() {

            @Override
            public void onChanged(Change<? extends Poisson> change) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while(change.next()) {
                    if(change.wasRemoved()) {
                        for (Poisson fish :
                                change.getRemoved()) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    //bigBorderPane.getChildren().remove(fish.getCircleClick());
                                    //bigBorderPane.getChildren().remove(fish.getSpritePoisson());
                                }
                            });
                        }
                    }

                    if(change.wasAdded()) {
                        for (Poisson fish :
                                change.getAddedSubList()) {
                            ImageView imgViewPoisson = new ImageView();
                            imgViewPoisson.imageProperty().bind(fish.spritePoissonProperty());
                            imgViewPoisson.fitHeightProperty().bind(fish.heightSpriteProperty());
                            imgViewPoisson.fitWidthProperty().bind(fish.widthSpriteProperty());
                            imgViewPoisson.translateXProperty().bind(fish.cooXPoissonProperty());
                            imgViewPoisson.translateYProperty().bind(fish.cooYPoissonProperty());
                            fish.getCircleClick().translateYProperty().bind(fish.cooYPoissonProperty());
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    bigBorderPane.getChildren().add(imgViewPoisson);
                                }
                            });
                        }
                    }
                }
            }
        });


        gM.getTheTimer().actualTimeProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("truc2");
                if(gM.getTheTimer().getActualTime() == 0) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gM.getThread2().stop();
                            gM.getThread1().stop();
                            try {
                                System.out.println("truc");
                                Stage theStage = gM.getMyStage();
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreGameOver.fxml"));
                                loader.setController(new FenetreGameOver(gM));
                                Parent root = loader.load();
                                Scene newScene = new Scene(root);
                                newScene.getStylesheets().add("css/styles.css");
                                theStage.setScene(newScene);
                                theStage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else
                    System.out.println(gM.getTheTimer().getActualTime());
            }
        });

        //click de l'utilisateur n'importe où
        bigBorderPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            double x = event.getSceneX();
            double y = event.getSceneY();
            textFieldTest.setText("Rentre dans le handler. coo :"+ x + "," + y);
            textFieldTest.prefColumnCountProperty().bind(textFieldTest.textProperty().length());

            //test de l'emplacement du click
            Circle circletest = new Circle();
            bigBorderPane.getChildren().add(circletest);
            circletest.setRadius(10);
            circletest.setFill(Color.WHITE);
            circletest.setCenterX(x);
            circletest.setCenterY(y);
            System.out.println("xclick :" + x + " yclick:" + y);
            for(Poisson p : gM.getvP().getListPoissons()) {
                Bounds boundsCirclePoisson = p.getCircleClick().getBoundsInParent();
                if(boundsCirclePoisson.contains(x,y)) { //check si le click a lieu dans le cercle du poisson
                    if(p.getClass().toString().equals("class classes.PoissonBombe")) {
                        p.setHeightSprite(130);
                        p.setWidthSprite(130);
                        p.setSpritePoisson(new Image("img/bigBang.png"));
                    }
                    p.setCatched(true);
                    gM.getLePecheur().setScorePecheur(gM.getLePecheur().getScorePecheur() + p.getValeur());
                    gM.getLePecheur().getListPoissonsAttrapes().add(p);
                    System.out.println("Attrapé !!!");
                }
            }

            //Déplacement du poisson à des coo fixes(instantanément...)
            //poissontest.setDeplaceurPoisson(new DeplaceurLent());
            //poissontest.getDeplaceurPoisson().deplacer(poissontest, 200, 200);
        });

        /*
        bigBorderPane.setRight(btnAccueil);
        //click de l'utilisateur sur le bouton d'accueil
        btnAccueil.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage theStage = gM.getMyStage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetreAccueil.fxml"));
                    loader.setController(new FenetreAccueil(gM));
                    Parent root = loader.load();
                    Scene theScene = new Scene(root);
                    theScene.getStylesheets().add("css/styles.css");
                    theStage.setScene(theScene));
                    theStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        */
    }


    //GETTERS & SETTERS
    public GameManager getgM() {
        return gM;
    }

    public void setgM(GameManager gM) {
        this.gM = gM;
    }
}
