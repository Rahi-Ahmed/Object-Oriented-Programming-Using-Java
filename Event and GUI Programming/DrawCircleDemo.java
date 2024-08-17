package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DrawCircleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Circle with radius 50
        Circle circle = new Circle(50);
        
        // Create a StackPane to hold the circle
        StackPane root = new StackPane(circle);
        
        // Create a Scene with the StackPane as the root and set the size (200x200)
        Scene scene = new Scene(root, 200, 200);
        
        // Set the title of the stage
        primaryStage.setTitle("Draw Circle Demo");
        
        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
