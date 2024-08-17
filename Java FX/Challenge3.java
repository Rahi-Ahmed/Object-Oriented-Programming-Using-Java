package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Challenge3 extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int CIRCLE_RADIUS = 20;
    private static final double STEP_SIZE = 10;

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

        // Handle arrow key events
        scene.setOnKeyPressed(e -> moveCircleWithArrowKeys(e.getCode()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to move the circle based on the arrow key pressed
    private void moveCircleWithArrowKeys(javafx.scene.input.KeyCode keyCode) {
        double deltaX = 0;
        double deltaY = 0;

        switch (keyCode) {
            case UP:
                deltaY = -STEP_SIZE;
                break;
            case DOWN:
                deltaY = STEP_SIZE;
                break;
            case LEFT:
                deltaX = -STEP_SIZE;
                break;
            case RIGHT:
                deltaX = STEP_SIZE;
                break;
            default:
                // Do nothing for other keys
                break;
        }

        // Update the circle's position
        circle.setCenterX(circle.getCenterX() + deltaX);
        circle.setCenterY(circle.getCenterY() + deltaY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
