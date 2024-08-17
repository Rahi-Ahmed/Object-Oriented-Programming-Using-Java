package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawRectangleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Rectangle with width 200 and height 100
        Rectangle rectangle = new Rectangle(200, 100);
        
        // Set the position of the rectangle to (100, 50)
        rectangle.setLayoutX(100);
        rectangle.setLayoutY(50);
        
        
        // Set the fill color to blue
        rectangle.setFill(Color.YELLOW);
        
        // Set the stroke color to red and stroke width to 2
        rectangle.setStroke(Color.RED);
        rectangle.setStrokeWidth(15);
         
         
        
        // Create a StackPane to hold the rectangle
        StackPane root = new StackPane(rectangle);
        
        // Create a Scene with the StackPane as the root and set the size (400x200)
        Scene scene = new Scene(root, 400, 200);
        
        // Set the title of the stage
        primaryStage.setTitle("Draw Rectangle Demo");
        
        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
