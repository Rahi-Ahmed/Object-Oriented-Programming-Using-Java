package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseEventHandlingDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Rectangle with width 200 and height 100
        Rectangle rectangle = new Rectangle(200, 100);
        rectangle.setFill(Color.LIGHTBLUE);

        // Create a StackPane to hold the rectangle
        StackPane root = new StackPane(rectangle);

        // Create a Scene with the StackPane as the root and set the size (400x200)
        Scene scene = new Scene(root, 400, 200);

        // Set the title of the stage
        primaryStage.setTitle("Mouse Event Handling Demo");

        // Handle mouse click event
        rectangle.setOnMouseClicked(e -> handleMouseClick());

        // Handle mouse movement event
        rectangle.setOnMouseMoved(e -> handleMouseMovement(e.getX(), e.getY()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to handle mouse clicks
    private void handleMouseClick() {
        System.out.println("Mouse Clicked!");
    }

    // Method to handle mouse movements
    private void handleMouseMovement(double x, double y) {
        System.out.println("Mouse Moved to: (X: " + x + ", Y: " + y + ")");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
