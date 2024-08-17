package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class DrawPolygonDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an array of points for the polygon (x, y)
        Double[] points = {50.0, 50.0, 150.0, 50.0, 100.0, 150.0};
        
        // Create a Polygon with the points
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(points);
        
        // Create a StackPane to hold the polygon
        StackPane root = new StackPane(polygon);
        
        // Create a Scene with the StackPane as the root and set the size (200x200)
        Scene scene = new Scene(root, 200, 200);
        
        // Set the title of the stage
        primaryStage.setTitle("Draw Polygon Demo");
        
        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

