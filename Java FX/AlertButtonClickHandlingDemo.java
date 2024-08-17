package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AlertButtonClickHandlingDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Button with the text "Click Me!"
        Button button = new Button("Click Me!");

        // Set the event handler for button clicks
        button.setOnAction(e -> showAlert());

        // Create a StackPane to hold the button
        StackPane root = new StackPane(button);

        // Create a Scene with the StackPane as the root and set the size (200x100)
        Scene scene = new Scene(root, 200, 100);

        // Set the title of the stage
        primaryStage.setTitle("Alert Button Click Handling Demo");

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to show an alert when the button is clicked
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Button Clicked!");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
