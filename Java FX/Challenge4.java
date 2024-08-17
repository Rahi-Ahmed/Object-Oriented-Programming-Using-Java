package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Challenge4 extends Application {

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
        scene.setOnKeyPressed(e -> handleKeyInput(e.getText().toUpperCase()));

        // Set the scene for the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to handle keyboard shortcuts for drawing shapes
    private void handleKeyInput(String key) {
        switch (key) {
            case "R":
                drawRectangle();
                break;
            case "C":
                drawCircle();
                break;
            case "T":
                drawTriangle();
                break;
            default:
                // Do nothing for other keys
                break;
        }
    }

    // Method to draw a rectangle on the specified coordinates
    private void drawRectangle() {
        scene.setOnMouseClicked(e -> {
            double rectWidth = 50;
            double rectHeight = 30;
            Rectangle rectangle = new Rectangle(e.getX() - (rectWidth / 2), e.getY() - (rectHeight / 2), rectWidth, rectHeight);
            rectangle.setFill(Color.BLUE);
            root.getChildren().add(rectangle);
        });
    }

    // Method to draw a circle on the specified coordinates
    private void drawCircle() {
        scene.setOnMouseClicked(e -> {
            double circleRadius = 20;
            Circle circle = new Circle(e.getX(), e.getY(), circleRadius, Color.RED);
            root.getChildren().add(circle);
        });
    }

    // Method to draw a triangle on the specified coordinates
    private void drawTriangle() {
        scene.setOnMouseClicked(e -> {
            double[] points = new double[]{
                    e.getX(), e.getY() - 20,
                    e.getX() - 20, e.getY() + 20,
                    e.getX() + 20, e.getY() + 20
            };
            Polygon triangle = new Polygon(points);
            triangle.setFill(Color.GREEN);
            root.getChildren().add(triangle);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
