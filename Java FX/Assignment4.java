package application;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment4 extends Application {

    private List<Ball> balls = new ArrayList<>();
    private Slider speedSlider;
    private Label speedLabel;
    private boolean animationPaused = false;

    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the balls
        Pane root = new Pane();

        // Create a scene
        Scene scene = new Scene(root, 600, 400);

        // Create a slider to adjust the speed
        speedSlider = new Slider(1, 10, 3);
        speedSlider.setLayoutX(10);
        speedSlider.setLayoutY(10);

        // Create a label to display the current speed
        speedLabel = new Label("Speed: " + (int) speedSlider.getValue());
        speedLabel.setLayoutX(150);
        speedLabel.setLayoutY(10);

        // Create control buttons
        Button addButton = new Button("Add Ball");
        addButton.setLayoutX(10);
        addButton.setLayoutY(50);

        Button removeButton = new Button("Remove Ball");
        removeButton.setLayoutX(100);
        removeButton.setLayoutY(50);

        Button upButton = new Button("Up");
        upButton.setLayoutX(200);
        upButton.setLayoutY(50);

        Button downButton = new Button("Down");
        downButton.setLayoutX(250);
        downButton.setLayoutY(50);

        Button pauseButton = new Button("Pause");
        pauseButton.setLayoutX(320);
        pauseButton.setLayoutY(50);

        Button resumeButton = new Button("Resume");
        resumeButton.setLayoutX(390);
        resumeButton.setLayoutY(50);

        // Event handlers for control buttons
        addButton.setOnAction(e -> addBall(root));
        removeButton.setOnAction(e -> removeBall(root));
        upButton.setOnAction(e -> balls.forEach(Ball::moveUp));
        downButton.setOnAction(e -> balls.forEach(Ball::moveDown));
        pauseButton.setOnAction(e -> pauseAllAnimations());
        resumeButton.setOnAction(e -> resumeAllAnimations());

        // Add event listener for speed slider
        speedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int speed = newValue.intValue();
            speedLabel.setText("Speed: " + speed);
            balls.forEach(ball -> ball.setSpeed(speed));
        });

        root.getChildren().addAll(addButton, removeButton, upButton, downButton, pauseButton, resumeButton, speedSlider, speedLabel);

        primaryStage.setTitle("Animation Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Add a new ball to the list of balls
        addBall(root);

        // Start the animation timer to update ball positions and colors
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!animationPaused) {
                    balls.forEach(Ball::update);
                }
            }
        };
        animationTimer.start();
    }

    private void addBall(Pane root) {
        Ball ball = new Ball();
        root.getChildren().add(ball.getCircle());
        balls.add(ball);
    }

    private void removeBall(Pane root) {
        if (!balls.isEmpty()) {
            Ball ball = balls.remove(balls.size() - 1);
            root.getChildren().remove(ball.getCircle());
        }
    }

    private void pauseAllAnimations() {
        animationPaused = true;
        balls.forEach(Ball::pause);
    }

    private void resumeAllAnimations() {
        animationPaused = false;
        balls.forEach(Ball::resume);
    }
    private class Ball {
        private Circle circle;
        private PathTransition pathTransition;
        private FadeTransition fadeTransition;
        private int speed = 3;
        private int direction = 1; // 1 for down, -1 for up
        private Random random = new Random();
        
        public void setSpeed(int speed) {
            this.speed = speed;
            pathTransition.setDuration(Duration.seconds(speed));
        }
        Ball() {
            // Create a circle
            circle = new Circle(20, Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            circle.setTranslateY(300);

            // Create a path for PathTransition
            Path path = new Path();
            path.getElements().add(new MoveTo(0, 300));
            path.getElements().add(new LineTo(600, 300));

            // Create a PathTransition for moving the circle along the path
            pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.seconds(speed));
            pathTransition.setNode(circle);
            pathTransition.setPath(path);
            pathTransition.setCycleCount(PathTransition.INDEFINITE);
            pathTransition.setAutoReverse(true);

            // Create a FadeTransition for fading the circle in and out
            fadeTransition = new FadeTransition(Duration.seconds(1), circle);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.2);
            fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
            fadeTransition.setAutoReverse(true);

            pathTransition.play();
            fadeTransition.play();
        }

        public Circle getCircle() {
            return circle;
        }


        public void moveUp() {
            direction = -1;
        }

        public void moveDown() {
            direction = 1;
        }

        public void pause() {
            pathTransition.pause();
        }

        public void resume() {
            pathTransition.play();
        }

        public void checkBoundaryCollision() {
            double ballY = circle.getTranslateY();
            if (ballY >= 300 || ballY <= 0) {
                direction *= -1;
                updateColor();
            }
        }

        public void updateColor() {
            circle.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }

        public void update() {
            checkBoundaryCollision();
            circle.setTranslateY(circle.getTranslateY() + (5 * direction));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
