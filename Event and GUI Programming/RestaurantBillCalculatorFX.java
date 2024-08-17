package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class RestaurantBillCalculatorFX extends Application {

    private TextField billAmountField;
    private RadioButton tenPercentRadioButton;
    private RadioButton fifteenPercentRadioButton;
    private RadioButton twentyPercentRadioButton;
    private RadioButton customPercentRadioButton;
    private TextField customPercentageField;
    private TextField numberOfPeopleField;
    private Label totalTipLabel;
    private Label grandTotalLabel;
    private Label individualShareLabel;

    @Override
    public void start(Stage primaryStage) {
        // Set up the main layout
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        // Create the input fields and labels
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(5);
        inputGrid.setAlignment(Pos.CENTER);

        Label billAmountLabel = new Label("Bill Amount:");
        billAmountField = new TextField();
        inputGrid.addRow(0, billAmountLabel, billAmountField);

        ToggleGroup tipPercentageGroup = new ToggleGroup();
        tenPercentRadioButton = new RadioButton("10%");
        fifteenPercentRadioButton = new RadioButton("15%");
        twentyPercentRadioButton = new RadioButton("20%");
        customPercentRadioButton = new RadioButton("Custom:");
        customPercentRadioButton.setUserData("custom");
        customPercentageField = new TextField();
        customPercentageField.setDisable(true);

        tenPercentRadioButton.setToggleGroup(tipPercentageGroup);
        fifteenPercentRadioButton.setToggleGroup(tipPercentageGroup);
        twentyPercentRadioButton.setToggleGroup(tipPercentageGroup);
        customPercentRadioButton.setToggleGroup(tipPercentageGroup);

        // Event handling for custom percentage radio button
        customPercentRadioButton.setOnAction(e -> {
            customPercentageField.setDisable(!customPercentRadioButton.isSelected());
        });

        inputGrid.addRow(1, tenPercentRadioButton, fifteenPercentRadioButton, twentyPercentRadioButton,
                customPercentRadioButton, customPercentageField);

        Label numberOfPeopleLabel = new Label("Number of People:");
        numberOfPeopleField = new TextField();
        inputGrid.addRow(2, numberOfPeopleLabel, numberOfPeopleField);

        vbox.getChildren().add(inputGrid);

        // Create the result labels
        GridPane resultGrid = new GridPane();
        resultGrid.setHgap(10);
        resultGrid.setVgap(5);
        resultGrid.setAlignment(Pos.CENTER);

        Label totalTipTextLabel = new Label("Total Tip:");
        totalTipLabel = new Label();
        resultGrid.addRow(0, totalTipTextLabel, totalTipLabel);

        Label grandTotalTextLabel = new Label("Grand Total:");
        grandTotalLabel = new Label();
        resultGrid.addRow(1, grandTotalTextLabel, grandTotalLabel);

        Label individualShareTextLabel = new Label("Individual Share:");
        individualShareLabel = new Label();
        resultGrid.addRow(2, individualShareTextLabel, individualShareLabel);

        vbox.getChildren().add(resultGrid);

        // Create buttons
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);

        Button calculateButton = new Button("Calculate");
        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save");

        // Set event handlers for the buttons
        calculateButton.setOnAction(e -> calculate());
        clearButton.setOnAction(e -> clear());
        saveButton.setOnAction(e -> saveToFile());

        buttonBox.getChildren().addAll(calculateButton, clearButton, saveButton);
        vbox.getChildren().add(buttonBox);

        // Create the scene and set the stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Restaurant Bill Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to calculate the bill details
    private void calculate() {
        try {
            // Get input values from the fields
            double billAmount = Double.parseDouble(billAmountField.getText());
            double tipPercentage;
            if (customPercentRadioButton.isSelected()) {
                tipPercentage = Double.parseDouble(customPercentageField.getText());
            } else {
                tipPercentage = getSelectedTipPercentage();
            }
            int numberOfPeople = Integer.parseInt(numberOfPeopleField.getText());

            // Calculate the results
            double totalTip = billAmount * (tipPercentage / 100);
            double grandTotal = billAmount + totalTip;
            double individualShare = grandTotal / numberOfPeople;

            // Display the results with two decimal places
            DecimalFormat df = new DecimalFormat("#.##");
            totalTipLabel.setText("$" + df.format(totalTip));
            grandTotalLabel.setText("$" + df.format(grandTotal));
            individualShareLabel.setText("$" + df.format(individualShare));

        } catch (NumberFormatException ex) {
            // Handle invalid inputs with informative error messages
            totalTipLabel.setText("Invalid Input");
            grandTotalLabel.setText("Invalid Input");
            individualShareLabel.setText("Invalid Input");
        }
    }

    // Method to clear all input fields and result labels
    private void clear() {
        billAmountField.clear();
        customPercentageField.clear();
        numberOfPeopleField.clear();
        totalTipLabel.setText("");
        grandTotalLabel.setText("");
        individualShareLabel.setText("");
    }

    // Method to save bill details to a file
    private void saveToFile() {
        try {
            // Get bill details
            double billAmount = Double.parseDouble(billAmountField.getText());
            double tipPercentage;
            if (customPercentRadioButton.isSelected()) {
                tipPercentage = Double.parseDouble(customPercentageField.getText());
            } else {
                tipPercentage = getSelectedTipPercentage();
            }
            int numberOfPeople = Integer.parseInt(numberOfPeopleField.getText());

            double totalTip = billAmount * (tipPercentage / 100);
            double grandTotal = billAmount + totalTip;
            double individualShare = grandTotal / numberOfPeople;

            // Open file for writing
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("bill_details.txt", true))) {
                // Append bill details to the file
                writer.write("Bill Amount: $" + billAmount);
                writer.newLine();
                writer.write("Tip Percentage: " + tipPercentage + "%");
                writer.newLine();
                writer.write("Total Tip: $" + totalTip);
                writer.newLine();
                writer.write("Grand Total: $" + grandTotal);
                writer.newLine();
                writer.write("Individual Share: $" + individualShare);
                writer.newLine();
                writer.newLine();
            } catch (IOException ex) {
                // Handle file writing exception with error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Saving File");
                alert.setContentText("An error occurred while saving the file. Please try again.");
                alert.showAndWait();
            }
        } catch (NumberFormatException ex) {
            // Handle invalid inputs with informative error messages
            totalTipLabel.setText("Invalid Input");
            grandTotalLabel.setText("Invalid Input");
            // "Invalid Input" will be displayed in the labels in case of invalid inputs.
            individualShareLabel.setText("Invalid Input");
        }
    }

    // Method to get the selected tip percentage
    private double getSelectedTipPercentage() {
        if (tenPercentRadioButton.isSelected()) {
            return 10.0;
        } else if (fifteenPercentRadioButton.isSelected()) {
            return 15.0;
        } else if (twentyPercentRadioButton.isSelected()) {
            return 20.0;
        } else {
            return 0.0;
        }
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}

