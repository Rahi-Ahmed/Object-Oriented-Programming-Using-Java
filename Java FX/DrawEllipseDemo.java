package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class DrawEllipseDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an Ellipse with radiusX 100 and radiusY 50
        Ellipse ellipse = new Ellipse(100, 50);
        
        // Create a StackPane to hold the ellipse
        StackPane root = new StackPane(ellipse);
        
        // Create a Scene with the StackPane as the root and set the size (300x200)
        Scene scene = new Scene(root, 300, 200);
        
        // Set the title of the stage
        primaryStage.setTitle("Draw Ellipse Demo");
        
        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
