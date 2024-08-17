package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseClickDrawPointsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the circles
        Pane root = new Pane();

        // Create a Scene with the Pane as the root and set the size (400x400)
        Scene scene = new Scene(root, 400, 400);

        // Set the title of the stage
        primaryStage.setTitle("Mouse Click Draw Points Demo");

        // Handle mouse click event
        scene.setOnMouseClicked(e -> drawPoint(root, e.getX(), e.getY()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to draw a point (circle) on the specified coordinates
    private void drawPoint(Pane pane, double x, double y) {
       Circle circle = new Circle(x, y, 5, Color.RED);
        pane.getChildren().add(circle);
        
   //     Rectangle rectangle = new Rectangle(x - 10, y - 10, 20, 20);
   //     rectangle.setFill(Color.BLUE);
   //     pane.getChildren().add(rectangle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
