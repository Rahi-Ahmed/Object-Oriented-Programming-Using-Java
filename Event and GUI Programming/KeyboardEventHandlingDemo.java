package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class KeyboardEventHandlingDemo extends Application {

    private Label label;

    @Override
    public void start(Stage primaryStage) {
        // Create a Label to display keyboard event information
        label = new Label("Press Arrow Keys!");

        // Create a StackPane to hold the Label
        StackPane root = new StackPane(label);

        // Create a Scene with the StackPane as the root and set the size (200x100)
        Scene scene = new Scene(root, 200, 100);

        // Set the title of the stage
        primaryStage.setTitle("Keyboard Event Handling Demo");

        // Handle keyboard arrow key events
        scene.setOnKeyPressed(e -> handleArrowKeyPress(e.getCode()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to handle arrow key presses
    private void handleArrowKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                label.setText("Up Arrow Pressed!");
                break;
            case DOWN:
                label.setText("Down Arrow Pressed!");
                break;
            case LEFT:
                label.setText("Left Arrow Pressed!");
                break;
            case RIGHT:
                label.setText("Right Arrow Pressed!");
                break;
            default:
                label.setText("Press Arrow Keys!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

