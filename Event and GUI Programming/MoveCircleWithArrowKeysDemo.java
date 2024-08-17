package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveCircleWithArrowKeysDemo extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int CIRCLE_RADIUS = 20;

    private Circle circle;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the circle
        Pane root = new Pane();

        // Create the circle and set its properties
        circle = new Circle(WIDTH / 2, HEIGHT / 2, CIRCLE_RADIUS, Color.RED);

        // Add the circle to the Pane
        root.getChildren().add(circle);

        // Create a Scene with the Pane as the root and set the size (WIDTH x HEIGHT)
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        // Set the title of the stage
        primaryStage.setTitle("Move Circle with Arrow Keys");

        // TODO: Add event handler to move the circle with arrow keys

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // TODO: Add the required functionality to move the circle with arrow keys

    public static void main(String[] args) {
        launch(args);
    }
}
