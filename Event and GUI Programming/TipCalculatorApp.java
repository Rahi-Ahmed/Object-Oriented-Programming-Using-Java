package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TipCalculatorApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tip Calculator");

        // Create input fields
        TextField billAmountField = new TextField();
        TextField tipPercentageField = new TextField();
        TextField numOfPeopleField = new TextField();

        // Create labels
        Label billAmountLabel = new Label("Bill Amount:");
        Label tipPercentageLabel = new Label("Tip Percentage:");
        Label numOfPeopleLabel = new Label("Number of People:");

        // Create calculate button
        Button calculateButton = new Button("Calculate");

        // Create result labels
        Label tipLabel = new Label("Total Tip:");
        Label grandTotalLabel = new Label("Grand Total:");
        Label individualShareLabel = new Label("Individual Share:");

        // Create result fields
        Label tipResult = new Label();
        Label grandTotalResult = new Label();
        Label individualShareResult = new Label();

        // Set action for the calculate button
        calculateButton.setOnAction(e -> {
            try {
                double billAmount = Double.parseDouble(billAmountField.getText());
                double tipPercentage = Double.parseDouble(tipPercentageField.getText());
                int numOfPeople = Integer.parseInt(numOfPeopleField.getText());

                double totalTip = billAmount * (tipPercentage / 100);
                double grandTotal = billAmount + totalTip;
                double individualShare = grandTotal / numOfPeople;

                tipResult.setText(String.format("$%.2f", totalTip));
                grandTotalResult.setText(String.format("$%.2f", grandTotal));
                individualShareResult.setText(String.format("$%.2f", individualShare));
            } catch (NumberFormatException ex) {
                // Handle invalid inputs
                tipResult.setText("Invalid Input");
                grandTotalResult.setText("Invalid Input");
                individualShareResult.setText("Invalid Input");
            }
        });

        // Create the layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(billAmountLabel, 0, 0);
        grid.add(billAmountField, 1, 0);
        grid.add(tipPercentageLabel, 0, 1);
        grid.add(tipPercentageField, 1, 1);
        grid.add(numOfPeopleLabel, 0, 2);
        grid.add(numOfPeopleField, 1, 2);
        grid.add(calculateButton, 1, 3);
        grid.add(tipLabel, 0, 4);
        grid.add(tipResult, 1, 4);
        grid.add(grandTotalLabel, 0, 5);
        grid.add(grandTotalResult, 1, 5);
        grid.add(individualShareLabel, 0, 6);
        grid.add(individualShareResult, 1, 6);

        // Set the scene
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

