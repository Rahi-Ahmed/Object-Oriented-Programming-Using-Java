package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class HBoxVBoxExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an HBox layout
        HBox hBox = new HBox(10); // spacing between nodes
        hBox.setPadding(new Insets(10));
        hBox.setStyle("-fx-background-color: lightblue;");
        
        // Create VBox layout for vertical alignment
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.setStyle("-fx-background-color: lightgreen;");
        
        // Add nodes to HBox
        hBox.getChildren().addAll(new Label("Item 1"), new Label("Item 2"), new Label("Item 3"));
        
        // Add nodes to VBox
        vBox.getChildren().addAll(new Label("Option 1"), new Label("Option 2"), new Label("Option 3"));

        // Create a scene
        Scene scene = new Scene(new VBox(hBox, vBox), 300, 200);

        primaryStage.setTitle("HBox and VBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
