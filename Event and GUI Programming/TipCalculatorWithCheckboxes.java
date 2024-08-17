package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipCalculatorWithCheckboxes extends Application {

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

        // Create checkboxes to choose tip percentage
        CheckBox tip10CheckBox = new CheckBox("10%");
        CheckBox tip15CheckBox = new CheckBox("15%");
        CheckBox tip20CheckBox = new CheckBox("20%");

        // Set action for the calculate button
        calculateButton.setOnAction(e -> {
            try {
                double billAmount = Double.parseDouble(billAmountField.getText());
                double tipPercentage = getSelectedTipPercentage(tip10CheckBox, tip15CheckBox, tip20CheckBox);
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
        VBox vbox = new VBox();
        VBox.setMargin(menuBar, new Insets(0, 0, 0, 0));
        VBox.setMargin(billAmountLabel, new Insets(10, 0, 0, 10));
        VBox.setMargin(billAmountField, new Insets(0, 10, 10, 10));
        VBox.setMargin(tipLabel, new Insets(10, 0, 0, 10));
        VBox.setMargin(tip10CheckBox, new Insets(0, 10, 0, 10));
        VBox.setMargin(tip15CheckBox, new Insets(0, 10, 0, 10));
        VBox.setMargin(tip20CheckBox, new Insets(0, 10, 10, 10));
        VBox.setMargin(numOfPeopleLabel, new Insets(10, 0, 0, 10));
        VBox.setMargin(numOfPeopleField, new Insets(0, 10, 10, 10));
        VBox.setMargin(calculateButton, new Insets(0, 10, 10, 10));
        VBox.setMargin(tipResultLabel, new Insets(10, 0, 0, 10));
        VBox.setMargin(grandTotalResultLabel, new Insets(10, 0, 0, 10));
        VBox.setMargin(individualShareResultLabel, new Insets(10, 0, 10, 10));

        vbox.getChildren().addAll(
                menuBar,
                billAmountLabel, billAmountField,
                tipLabel, tip10CheckBox, tip15CheckBox, tip20CheckBox,
                numOfPeopleLabel, numOfPeopleField,
                calculateButton,
                tipResultLabel, grandTotalResultLabel, individualShareResultLabel
        );

        // Set the scene
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Helper method to get the selected tip percentage
    private double getSelectedTipPercentage(CheckBox... checkboxes) {
        for (CheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                String text = checkbox.getText();
                return Double.parseDouble(text.substring(0, text.length() - 1));
            }
        }
        return 0.0; // Default to 0% if none selected
    }

    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Tip Calculator");
        alert.setHeaderText("Tip Calculator v1.0");
        alert.setContentText("A simple tool to calculate tips and share bills.");
        alert.showAndWait();
    }
}
