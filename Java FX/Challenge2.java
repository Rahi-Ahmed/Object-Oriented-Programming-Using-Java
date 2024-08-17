package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Challenge2 extends Application {

    private int rectangleCount = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the shapes
        Pane root = new Pane();

        // Create a Scene with the Pane as the root and set the size (400x400)
        Scene scene = new Scene(root, 400, 400);

        // Set the title of the stage
        primaryStage.setTitle("Count Rectangle Clicks");

        // Create a label to display the rectangle count
        Label label = new Label("Rectangle Count: 0");
        label.setLayoutX(10);
        label.setLayoutY(10);
        root.getChildren().add(label);

        // Handle mouse click event
        scene.setOnMouseClicked(e -> drawRectangle(root, label, e.getX(), e.getY()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to draw a rectangle on the specified coordinates
    private void drawRectangle(Pane pane, Label label, double x, double y) {
        rectangleCount++;

        Rectangle rectangle = new Rectangle(x - 10, y - 10, 20, 20);
        rectangle.setFill(Color.BLUE);
        pane.getChildren().add(rectangle);

        // Update the label with the current rectangle count
        label.setText("Rectangle Count: " + rectangleCount);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

