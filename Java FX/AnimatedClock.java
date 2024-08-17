package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnimatedClock extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Create clock components
        Circle clockCircle = new Circle(150, Color.WHITE);
        clockCircle.setStroke(Color.BLACK);
        root.setCenter(clockCircle);

        Circle centerCircle = new Circle(150, 150, 5, Color.BLACK);
        root.getChildren().add(centerCircle);
        BorderPane.setAlignment(centerCircle, javafx.geometry.Pos.CENTER);

        // Create clock hands
        Line hourHand = new Line();
        hourHand.setStrokeWidth(6);
        root.getChildren().add(hourHand);

        Line minuteHand = new Line();
        minuteHand.setStrokeWidth(4);
        root.getChildren().add(minuteHand);

        Line secondHand = new Line();
        secondHand.setStroke(Color.RED);
        root.getChildren().add(secondHand);

        // Create digital time display
        Text digitalTime = new Text();
        digitalTime.setStyle("-fx-font-size: 20;");
        root.setBottom(digitalTime);
        BorderPane.setAlignment(digitalTime, javafx.geometry.Pos.CENTER);

        // Create animation timeline
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    updateClock(hourHand, minuteHand, secondHand, digitalTime);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Set up the scene
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Animated Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateClock(Line hourHand, Line minuteHand, Line secondHand, Text digitalTime) {
        // Get current time
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(now);
        digitalTime.setText(formattedTime);

        // Calculate angles for clock hands
        double secondAngle = now.getSeconds() * 6;
        double minuteAngle = now.getMinutes() * 6 + secondAngle / 60;
        double hourAngle = now.getHours() * 30 + minuteAngle / 12;

        // Rotate clock hands
        secondHand.setStartX(150);
        secondHand.setStartY(150);
        secondHand.setEndX(150 + 100 * Math.cos(Math.toRadians(secondAngle)));
        secondHand.setEndY(150 + 100 * Math.sin(Math.toRadians(secondAngle)));  // Fixed y-coordinate

        minuteHand.setStartX(150);
        minuteHand.setStartY(150);
        minuteHand.setEndX(150 + 80 * Math.cos(Math.toRadians(minuteAngle)));
        minuteHand.setEndY(150 + 80 * Math.sin(Math.toRadians(minuteAngle)));  // Fixed y-coordinate

        hourHand.setStartX(150);
        hourHand.setStartY(150);
        hourHand.setEndX(150 + 60 * Math.cos(Math.toRadians(hourAngle)));
        hourHand.setEndY(150 + 60 * Math.sin(Math.toRadians(hourAngle)));  // Fixed y-coordinate
    }

    public static void main(String[] args) {
        launch(args);
    }
}
