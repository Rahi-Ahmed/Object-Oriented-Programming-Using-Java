package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Challenge1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the circles
        Pane root = new Pane();

        // Create a Scene with the Pane as the root and set the size (400x400)
        Scene scene = new Scene(root, 400, 400);

        // Set the title of the stage
        primaryStage.setTitle("Change Circle Color");

        // Handle mouse click event
        scene.setOnMouseClicked(e -> drawRandomColorCircle(root, e.getX(), e.getY()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to draw a circle with a random color on the specified coordinates
    private void drawRandomColorCircle(Pane pane, double x, double y) {
        Random rand = new Random();

        // Generate random RGB values for the color
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);
        Color randomColor = Color.rgb(red, green, blue);

        Circle circle = new Circle(x, y, 5, randomColor);
        pane.getChildren().add(circle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
