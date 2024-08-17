package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CssStylingApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSS Styling Example");

        // Create a VBox as the root container
        VBox root = new VBox(10); // Set spacing between components
        root.setStyle("-fx-background-color: #f4f4c4"); // Set background color using CSS - yellow 

        // Create and style components
        Button styledButton = new Button("Styled Button");
        styledButton.getStyleClass().add("styled-button"); // Add custom style class

        Label styledLabel = new Label("Styled Label");
        styledLabel.setId("styled-label"); // Set ID for styling

        // Add components to the VBox
        root.getChildren().addAll(styledButton, styledLabel);

        // Create a scene with the root container
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // Load external CSS file

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
