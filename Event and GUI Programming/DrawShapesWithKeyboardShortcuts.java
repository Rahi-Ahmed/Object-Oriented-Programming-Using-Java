package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class DrawShapesWithKeyboardShortcuts extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Pane root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the shapes
        root = new Pane();

        // Create a Scene with the Pane as the root and set the size (WIDTH x HEIGHT)
        scene = new Scene(root, WIDTH, HEIGHT);

        // Set the title of the stage
        primaryStage.setTitle("Draw Shapes with Keyboard Shortcuts");

        // Handle keyboard shortcuts for drawing shapes
        scene.setOnKeyPressed(e -> drawShapeWithShortcut(e.getCode()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // TODO: Add the required functionality to draw different shapes with keyboard shortcuts

    private Object drawShapeWithShortcut(KeyCode code) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
        launch(args);
    }
}
