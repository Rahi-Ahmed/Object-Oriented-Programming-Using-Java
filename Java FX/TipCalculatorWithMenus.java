package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipCalculatorWithMenus extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tip Calculator");

        // Create input fields
        TextField billAmountField = new TextField();
        TextField numOfPeopleField = new TextField();

        // Create labels
        Label billAmountLabel = new Label("Bill Amount:");
        Label numOfPeopleLabel = new Label("Number of People:");
        Label tipLabel = new Label("Tip Percentage:");

        // Create calculate button
        Button calculateButton = new Button("Calculate");

        // Create result labels
        Label tipResultLabel = new Label("Total tip:");
        Label grandTotalResultLabel = new Label("Grand Total:");
        Label individualShareResultLabel = new Label("Individual Share:");

        // Create the slider and label for choosing tip percentage
        Slider tipSlider = new Slider(0, 30, 15);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        Label tipPercentageLabel = new Label("15.0%"); // Initial value

        // Update label dynamically when slider value changes
        tipSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                tipPercentageLabel.setText(String.format("%.1f%%", newValue))
        );

        // Set action for the calculate button
        calculateButton.setOnAction(e -> {
            try {
                double billAmount = Double.parseDouble(billAmountField.getText());
                double tipPercentage = tipSlider.getValue();
                int numOfPeople = Integer.parseInt(numOfPeopleField.getText());

                double totalTip = billAmount * (tipPercentage / 100);
                double grandTotal = billAmount + totalTip;
                double individualShare = grandTotal / numOfPeople;

                tipResultLabel.setText(String.format("Total tip: $%.2f", totalTip));
                grandTotalResultLabel.setText(String.format("Grand Total: $%.2f", grandTotal));
                individualShareResultLabel.setText(String.format("Individual Share: $%.2f", individualShare));
            } catch (NumberFormatException ex) {
                // Handle invalid inputs
                tipResultLabel.setText("Total tip: Invalid Input");
                grandTotalResultLabel.setText("Grand Total: Invalid Input");
                individualShareResultLabel.setText("Individual Share: Invalid Input");
            }
        });

        // Create Menus
        Menu fileMenu = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> primaryStage.close());
        fileMenu.getItems().addAll(exitMenuItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(e -> showAboutDialog());
        helpMenu.getItems().addAll(aboutMenuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Create the layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(
                billAmountLabel, billAmountField,
                tipLabel, tipSlider, tipPercentageLabel,
                numOfPeopleLabel, numOfPeopleField,
                calculateButton,
                tipResultLabel, grandTotalResultLabel, individualShareResultLabel
        );

        // Set the scene
        VBox root = new VBox(menuBar, vbox);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Tip Calculator");
        alert.setHeaderText("Tip Calculator v1.0");
        alert.setContentText("A simple tool to calculate tips and share bills.");
        alert.showAndWait();
    }
}
