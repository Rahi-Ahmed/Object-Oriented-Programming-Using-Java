import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI extends JFrame {
    private JTextField heightField;
    private JTextField weightField;
    private JLabel resultLabel;

    public BMICalculatorGUI() {
        // Set up the frame
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));

        // Create input labels and text fields
        JLabel heightLabel = new JLabel("Height (in cm):"); // Create a label for height input
        heightField = new JTextField(); // Create a text field for height input
        JLabel weightLabel = new JLabel("Weight (in kg):"); // Create a label for weight input
        weightField = new JTextField(); // Create a text field for weight input

        // Create a button for BMI calculation
        JButton calculateButton = new JButton("Calculate BMI");

        // Create a label to display the result
        resultLabel = new JLabel();

        // Add components to the frame
        add(heightLabel); // Add the height label to the frame
        add(heightField); // Add the height text field to the frame
        add(weightLabel); // Add the weight label to the frame
        add(weightField); // Add the weight text field to the frame
        add(calculateButton); // Add the calculate button to the frame
        add(resultLabel); // Add the result label to the frame

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Get the height and weight values from the text fields
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());

        // Calculate the BMI
        double bmi = weight / ((height / 100) * (height / 100));

        // Display the result
        resultLabel.setText("Your BMI is: " + String.format("%.2f", bmi));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BMICalculatorGUI calculator = new BMICalculatorGUI();
                calculator.setVisible(true);
            }
        });
    }
}
