package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class LabelColorChanger extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");

        Button button = new Button("Change Color");
        button.setOnAction(event -> changeLabelColor(label));

        VBox root = new VBox(10); // VBox to stack components vertically
        root.getChildren().addAll(label, button);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Label Color Changer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeLabelColor(Label label) {
        Random random = new Random();
        Color color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        label.setTextFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


