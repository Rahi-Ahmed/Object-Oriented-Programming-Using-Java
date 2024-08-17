/*
 * package application;
 * 
 * import javafx.animation.FadeTransition; import
 * javafx.animation.PathTransition; import javafx.animation.TranslateTransition;
 * import javafx.application.Application; import javafx.scene.Scene; import
 * javafx.scene.control.Button; import javafx.scene.control.Label; import
 * javafx.scene.control.Slider; import javafx.scene.layout.BorderPane; import
 * javafx.scene.layout.HBox; import javafx.scene.layout.Pane; import
 * javafx.scene.paint.Color; import javafx.scene.shape.Circle; import
 * javafx.scene.shape.LineTo; import javafx.scene.shape.MoveTo; import
 * javafx.scene.shape.Path; import javafx.stage.Stage; import
 * javafx.util.Duration;
 * 
 * public class Challenge7 extends Application {
 * 
 * private double ballSpeed = 2.0; // Initial ball speed private boolean
 * isMovingUp = true; // Initial direction private boolean isPaused = false; //
 * Animation pause state private TranslateTransition bounceTransition;
 * 
 * @Override public void start(Stage primaryStage) { // Create a circle Circle
 * circle = new Circle(20, Color.RED); circle.setTranslateY(300);
 * 
 * // Create a path for PathTransition Path path = new Path();
 * path.getElements().add(new MoveTo(0, 300)); path.getElements().add(new
 * LineTo(600, 300));
 * 
 * // Create a PathTransition for moving the circle along the path
 * PathTransition pathTransition = new PathTransition();
 * pathTransition.setDuration(Duration.seconds(3));
 * pathTransition.setNode(circle); pathTransition.setPath(path);
 * pathTransition.setCycleCount(PathTransition.INDEFINITE);
 * pathTransition.setAutoReverse(true); pathTransition.play();
 * 
 * // Create a FadeTransition for fading the circle in and out FadeTransition
 * fadeTransition = new FadeTransition(Duration.seconds(1), circle);
 * fadeTransition.setFromValue(1.0); fadeTransition.setToValue(0.2);
 * fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
 * fadeTransition.setAutoReverse(true); fadeTransition.play();
 * 
 * // Create UI components Label speedLabel = new Label("Speed:"); Label
 * directionLabel = new Label("Direction:"); Slider speedSlider = new
 * Slider(0.5, 5, 2); // Set initial speed to 2 Button toggleDirectionButton =
 * new Button("Toggle Direction"); Button togglePauseButton = new
 * Button("Pause");
 * 
 * // Create animation for bouncing vertically bounceTransition = new
 * TranslateTransition(Duration.seconds(1)); bounceTransition.setNode(circle);
 * bounceTransition.setCycleCount(TranslateTransition.INDEFINITE);
 * 
 * // Set up UI interactions
 * speedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
 * ballSpeed = newValue.doubleValue();
 * bounceTransition.setDuration(Duration.seconds(1 / ballSpeed)); });
 * 
 * toggleDirectionButton.setOnAction(event -> isMovingUp = !isMovingUp);
 * 
 * togglePauseButton.setOnAction(event -> { isPaused = !isPaused; if (isPaused)
 * { bounceTransition.pause(); togglePauseButton.setText("Resume"); } else {
 * bounceTransition.play(); togglePauseButton.setText("Pause"); } });
 * 
 * // Create HBox for bottom controls HBox bottomControls = new HBox(10);
 * bottomControls.setPadding(new javafx.geometry.Insets(10));
 * bottomControls.getChildren().addAll(speedLabel, speedSlider, directionLabel,
 * toggleDirectionButton, togglePauseButton);
 * 
 * // Create a BorderPane for UI layout BorderPane borderPane = new
 * BorderPane(); borderPane.setCenter(circle); // Display the bouncing circle
 * borderPane.setBottom(bottomControls); // Add bottom controls
 * 
 * // Create a scene Scene scene = new Scene(borderPane, 600, 400);
 * 
 * primaryStage.setTitle("Challenge 7: Bouncing Ball Animation");
 * primaryStage.setScene(scene); primaryStage.show();
 * 
 * // Set up bouncing animation bounceTransition.setByY(isMovingUp ? -300 :
 * 300); bounceTransition.setDuration(Duration.seconds(1 / ballSpeed));
 * bounceTransition.setAutoReverse(true); bounceTransition.play(); }
 * 
 * public static void main(String[] args) { launch(args); } }
 */

//package test;
package application;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Challenge7 extends Application {

	private List<BouncingBall> bouncingBalls = new ArrayList<>();
	private Label speedLabel;

	@Override
	public void start(Stage primaryStage) {
		// Create the root pane and control buttons
		Pane root = new Pane();
		HBox controls = new HBox(10);
		controls.setAlignment(Pos.CENTER);

		// Create the speed label
		speedLabel = new Label("Speed: ");

		// Create buttons for controlling the animation
		Button addBallButton = new Button("Add Ball");
		Button removeBallButton = new Button("Remove Ball");
		Button upButton = new Button("Up");
		Button downButton = new Button("Down");
		Button pauseResumeButton = new Button("Pause/Resume");

		// Create a control buttons pane and add buttons
		HBox controlButtons = new HBox(10);
		controlButtons.setAlignment(Pos.CENTER);
		controlButtons.getChildren().addAll(addBallButton, removeBallButton, upButton, downButton, pauseResumeButton,
				speedLabel);

		// Create the scene and set it to the stage
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Bouncing Ball Animation");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Add the control buttons to the root pane
		root.getChildren().addAll(controls, controlButtons);

		// Set up button actions
		addBallButton.setOnAction(event -> addBouncingBall(root));
		removeBallButton.setOnAction(event -> removeBouncingBall(root));

		upButton.setOnAction(event -> {
			for (BouncingBall ball : bouncingBalls) {
				ball.moveUp();
			}
		});

		downButton.setOnAction(event -> {
			for (BouncingBall ball : bouncingBalls) {
				ball.moveDown();
			}
		});

		pauseResumeButton.setOnAction(event -> {
			for (BouncingBall ball : bouncingBalls) {
				ball.togglePauseResume();
			}
		});

		// Start the animation loop
		AnimationTimer animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				for (BouncingBall ball : bouncingBalls) {
					ball.update();
				}
			}
		};
		animationTimer.start();
	}

	// Method to add a new bouncing ball to the list
	private void addBouncingBall(Pane root) {
		BouncingBall newBall = new BouncingBall(root, speedLabel);
		bouncingBalls.add(newBall);
	}

	// Method to remove the last bouncing ball from the list
	private void removeBouncingBall(Pane root) {
		if (!bouncingBalls.isEmpty()) {
			BouncingBall removedBall = bouncingBalls.remove(bouncingBalls.size() - 1);
			removedBall.cleanup(root);
		}
	}

	// Inner class to represent a bouncing ball
	private class BouncingBall {
		private Circle circle;
		private TranslateTransition translateTransition;
		private FadeTransition fadeTransition;
		private Color color;
		private double speedY;
		private boolean movingUp;
		private boolean paused = false;
		private Label speedLabel;

		public BouncingBall(Pane parent, Label speedLabel) {
			// Create a circle for the bouncing ball
			circle = new Circle(20);
			Random random = new Random();
			color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
			circle.setFill(color);
			this.speedLabel = speedLabel;

			// Initialize properties
			movingUp = true;
			speedY = 2 + random.nextDouble() * 3;

			// Create TranslateTransition to move the ball
			translateTransition = new TranslateTransition(Duration.seconds(0), circle);

			// Create FadeTransition for fading in and out
			fadeTransition = new FadeTransition(Duration.seconds(1), circle);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0.2);
			fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
			fadeTransition.setAutoReverse(true);
			fadeTransition.play();

			// Add the circle to the parent pane
			parent.getChildren().add(circle);

			// Set initial position and start animations
			resetPosition(parent);

			// Update the speed label with initial speed
			updateSpeedLabel();
		}

		// Move the ball upwards
		public void moveUp() {
			// increase the speed

			speedY += 0.5;
			updateSpeedLabel();

		}

		// Move the ball downwards
		public void moveDown() {
			// slow down the speed
			if (speedY > 0.5) {
				speedY -= 0.5;
			} else {
				speedY = 0;
			}
			updateSpeedLabel();

		}

		// Toggle between pause and resume states
		public void togglePauseResume() {
			paused = !paused;
		}

		// Update the speed label with the current speed
		private void updateSpeedLabel() {
			speedLabel.setText("Speed: " + String.format("%.2f pps", speedY));
		}

		// Update the ball's position
		public void update() {
			if (!paused) {
				double posY = circle.getTranslateY();
				if (movingUp) {
					circle.setTranslateY(posY - speedY);
					if (posY <= 0) {
						movingUp = false;
						color = Color.rgb(new Random().nextInt(256), new Random().nextInt(256),
								new Random().nextInt(256));
						circle.setFill(color);
					}
				} else {
					circle.setTranslateY(posY + speedY);
					if (posY >= circle.getScene().getHeight()) {
						movingUp = true;
						color = Color.rgb(new Random().nextInt(256), new Random().nextInt(256),
								new Random().nextInt(256));
						circle.setFill(color);
					}
				}
				updateSpeedLabel();
			}
		}

		// Reset the ball's position to the bottom of the scene
		public void resetPosition(Pane parent) {
			circle.setTranslateX(new Random().nextInt((int) parent.getWidth()));
			circle.setTranslateY(parent.getHeight());
		}

		// Remove the ball from the parent pane
		public void cleanup(Pane parent) {
			parent.getChildren().remove(circle);
		}
	}

	// Launch the JavaFX application
	public static void main(String[] args) {
		launch(args);
	}
}
