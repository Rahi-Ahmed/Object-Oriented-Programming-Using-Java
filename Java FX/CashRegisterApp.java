package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CashRegisterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cash Register");

        // Create input fields
        TextField totalAmountDueField = new TextField();
        TextField amountPaidField = new TextField();

        // Create labels
        Label totalAmountDueLabel = new Label("Total Amount Due:");
        Label amountPaidLabel = new Label("Amount Paid:");
        Label changeLabel = new Label("Change:");

        // Create calculate button
        Button calculateButton = new Button("Calculate");

        // Create result label
        Label resultLabel = new Label();

        // Create checkboxes
        CheckBox fiveDollarBox = new CheckBox("$5");
        CheckBox tenDollarBox = new CheckBox("$10");
        CheckBox twentyDollarBox = new CheckBox("$20");

        // Set action for the calculate button
        calculateButton.setOnAction(e -> {
            try {
                double totalAmountDue = Double.parseDouble(totalAmountDueField.getText());
                double amountPaid = Double.parseDouble(amountPaidField.getText());

                double change = amountPaid - totalAmountDue;

                // Calculate number of bills to be returned
                StringBuilder changeDetails = new StringBuilder("Return: ");
                if (fiveDollarBox.isSelected()) {
                    int numFiveDollarBills = (int) (change / 5);
                    changeDetails.append("$5*").append(numFiveDollarBills).append(", ");
                }
                if (tenDollarBox.isSelected()) {
                    int numTenDollarBills = (int) (change / 10);
                    changeDetails.append("$10*").append(numTenDollarBills).append(", ");
                }
                if (twentyDollarBox.isSelected()) {
                    int numTwentyDollarBills = (int) (change / 20);
                    changeDetails.append("$20*").append(numTwentyDollarBills).append(", ");
                }

                resultLabel.setText(changeDetails.toString());
            } catch (NumberFormatException ex) {
                // Handle invalid inputs
                resultLabel.setText("Invalid Input");
            }
        });

        // Create menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> primaryStage.close());
        fileMenu.getItems().add(exitItem);
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Create the layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(totalAmountDueLabel, 0, 0);
        grid.add(totalAmountDueField, 1, 0);
        grid.add(amountPaidLabel, 0, 1);
        grid.add(amountPaidField, 1, 1);
        grid.add(fiveDollarBox, 0, 2);
        grid.add(tenDollarBox, 1, 2);
        grid.add(twentyDollarBox, 2, 2);
        grid.add(calculateButton, 1, 3);
        grid.add(changeLabel, 0, 4);
        grid.add(resultLabel, 1, 4);

        // Create the scene
        Scene scene = new Scene(grid, 400, 250);

        // Set the menu bar at the top
        grid.add(menuBar, 0, 5, 3, 1);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
