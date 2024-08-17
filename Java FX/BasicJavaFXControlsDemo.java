package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BasicJavaFXControlsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the UI layout using a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Label control
        Label nameLabel = new Label("Name:");
        gridPane.add(nameLabel, 0, 0);

        // TextField control
        TextField nameTextField = new TextField();
        gridPane.add(nameTextField, 1, 0);

        // Label control
        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 1);

        // PasswordField control
        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 1);

        // Label control
        Label descriptionLabel = new Label("Description:");
        gridPane.add(descriptionLabel, 0, 2);

        // TextArea control
        TextArea descriptionTextArea = new TextArea();
        gridPane.add(descriptionTextArea, 1, 2);

        // CheckBox control
        CheckBox subscribeCheckBox = new CheckBox("Subscribe to newsletter");
        gridPane.add(subscribeCheckBox, 0, 3, 2, 1); // Span 2 columns

        // RadioButton controls
        RadioButton radioButton1 = new RadioButton("Option 1");
        RadioButton radioButton2 = new RadioButton("Option 2");
        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        gridPane.add(radioButton1, 0, 4);
        gridPane.add(radioButton2, 1, 4);

        // Button control
        Button submitButton = new Button("Submit");
        gridPane.add(submitButton, 0, 5, 2, 1); // Span 2 columns

        // Create a Scene with the GridPane as the root and set the size (400x300)
        Scene scene = new Scene(gridPane, 400, 300);

        // Set the title of the stage
        primaryStage.setTitle("Basic JavaFX Controls Demo");

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

