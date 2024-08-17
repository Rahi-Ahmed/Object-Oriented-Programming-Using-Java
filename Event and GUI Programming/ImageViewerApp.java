package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageViewerApp extends Application {

    // List to store loaded images
    private List<Image> images = new ArrayList<>();
    // Index of the currently displayed image
    private int currentImageIndex = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create an ImageView to display images
        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        // Button to show previous image
        Button previousButton = new Button("Previous");
        previousButton.setOnAction(event -> showPreviousImage(imageView));

        // Button to show next image
        Button nextButton = new Button("Next");
        nextButton.setOnAction(event -> showNextImage(imageView));

        // Button to load an image
        Button loadButton = new Button("Load Image");
        loadButton.setOnAction(event -> loadImage(imageView));

        // Horizontal box to hold navigation buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(previousButton, nextButton, loadButton);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        // Vertical box to hold ImageView and buttons
        VBox root = new VBox(20);
        root.getChildren().addAll(imageView, buttonBox);
        root.setStyle("-fx-padding: 20px");

        // Create a scene with the root VBox
        Scene scene = new Scene(root, 500, 400);

        // Set stage title and scene
        primaryStage.setTitle("Image Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Show the previous image in the ImageView
    private void showPreviousImage(ImageView imageView) {
        currentImageIndex = (currentImageIndex - 1 + images.size()) % images.size();
        imageView.setImage(images.get(currentImageIndex));
    }

    // Show the next image in the ImageView
    private void showNextImage(ImageView imageView) {
        currentImageIndex = (currentImageIndex + 1) % images.size();
        imageView.setImage(images.get(currentImageIndex));
    }

    // Load an image using FileChooser
    private void loadImage(ImageView imageView) {
        FileChooser fileChooser = new FileChooser();
        // Filter for image file types
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Load the selected image and add it to the list
            Image image = new Image(selectedFile.toURI().toString());
            images.add(image);
            currentImageIndex = images.size() - 1;
            imageView.setImage(image);
        }
    }
}
