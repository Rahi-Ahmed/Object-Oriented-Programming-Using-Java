package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Challenge5 extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private TextField operatorField;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create UI elements
        Label num1Label = new Label("Number 1:");
        Label num2Label = new Label("Number 2:");
        Label operatorLabel = new Label("Operator (+, -, *, /):");
        num1Field = new TextField();
        num2Field = new TextField();
        operatorField = new TextField();
        Button calculateButton = new Button("Calculate");
        resultLabel = new Label();

        // Add UI elements to the grid
        grid.add(num1Label, 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(num2Label, 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(operatorLabel, 0, 2);
        grid.add(operatorField, 1, 2);
        grid.add(calculateButton, 0, 3, 2, 1);
        grid.add(resultLabel, 0, 4, 2, 1);

        // Handle button click event
        calculateButton.setOnAction(e -> calculateResult());
    }

    // Method to calculate the result based on the operator and input numbers
    private void calculateResult() {
        String operator = operatorField.getText();
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());
        double result = 0.0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultLabel.setText("Error: Division by zero!");
                    return;
                }
                break;
            default:
                resultLabel.setText("Invalid operator.");
                return;
        }

        resultLabel.setText("Result: " + result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
