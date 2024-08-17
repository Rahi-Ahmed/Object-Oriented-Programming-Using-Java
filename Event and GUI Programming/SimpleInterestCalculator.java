import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculator extends Frame {
    // GUI components
    private Label principalLabel, rateLabel, timeLabel, resultLabel;
    private TextField principalTextField, rateTextField, timeTextField;
    private Button calculateButton;

    public SimpleInterestCalculator() {
        // Frame setup
        setTitle("Simple Interest Calculator");
        setSize(400, 200);
        setLayout(new FlowLayout());

        // Create labels
        principalLabel = new Label("Principal Amount:");
        rateLabel = new Label("Rate of Interest:");
        timeLabel = new Label("Time Period (in years):");

        // Create text fields
        principalTextField = new TextField(10);
        rateTextField = new TextField(10);
        timeTextField = new TextField(10);

        // Create button
        calculateButton = new Button("Calculate Interest");

        // Create result label
        resultLabel = new Label("");

        // Event listeners
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateInterest();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Add components to the frame
        add(principalLabel);
        add(principalTextField);
        add(rateLabel);
        add(rateTextField);
        add(timeLabel);
        add(timeTextField);
        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }

    // Method to calculate simple interest
    private void calculateInterest() {
        try {
            // Get input values from text fields
            double principal = Double.parseDouble(principalTextField.getText());
            double rate = Double.parseDouble(rateTextField.getText());
            double time = Double.parseDouble(timeTextField.getText());

            // Calculate simple interest
            double interest = (principal * rate * time) / 100;

            // Display the result
            resultLabel.setText("Simple Interest: " + interest);
        } catch (NumberFormatException ex) {
            // Handle invalid input
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new SimpleInterestCalculator();
    }
}
