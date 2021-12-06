package fxtimer;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXTimer {

    public FXTimer() {
        // private class constant and some variables
        Integer STARTTIME = 15;
        final Timeline[] timeline = {null};
        final Label[] timerLabel = {new Label()};
        final Integer[] timeSeconds = {STARTTIME};


        // Setup the Stage and the Scene (the scene graph)
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        // Configure the Label
        timerLabel[0].setText(timeSeconds[0].toString());
        timerLabel[0].setTextFill(Color.RED);
        timerLabel[0].setStyle("-fx-font-size: 4em;");

        // Create and configure the Button
        Button button = new Button();
        button.setText("Start Timer");
        button.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
             //timeSeconds[0]--;
             //timerLabel[0].setText(timeSeconds[0].toString());
                if (timeline[0] != null) {
                    timeline[0].stop();
                }

                timeSeconds[0] = STARTTIME;

                // update timerLabel
                timerLabel[0].setText(timeSeconds.toString());
                timeline[0] = new Timeline();
                timeline[0].setCycleCount(Timeline.INDEFINITE);
                timeline[0].getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler() {
                                    @Override
                                    public void handle(Event event) {
                                        timeSeconds[0]--;
                                        // update timerLabel
                                        timerLabel[0].setText(
                                                timeSeconds[0].toString());
                                        if (timeSeconds[0] <= 0) {
                                            timeline[0].stop();
                                        }
                                    }
                                }));
                timeline[0].playFromStart();
            }
        });

        // Create and configure VBox
        // gap between components is 20
        VBox vb = new VBox(20);
        // center the components within VBox
        vb.setAlignment(Pos.CENTER);
        // Make it as wide as the application frame (scene)
        vb.setPrefWidth(scene.getWidth());
        // Move the VBox down a bit
        vb.setLayoutY(30);
        // Add the button and timerLabel to the VBox
        vb.getChildren().addAll(button, timerLabel[0]);
        // Add the VBox to the root component
        root.getChildren().add(vb);

        //launcher.Launcher.getMyStage().setScene(scene);
        //launcher.Launcher.getMyStage().show();
    }
}
