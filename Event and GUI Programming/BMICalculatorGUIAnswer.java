import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUIAnswer extends JFrame {
    private JTextField heightField;
    private JTextField weightField;
    private JLabel resultLabel;
    private JLabel categoryLabel;

    public BMICalculatorGUIAnswer() {
        // Set up the frame
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLayout(new GridLayout(5, 1));

        // Create input labels and text fields
        JLabel heightLabel = new JLabel("Height (in cm):");
        heightField = new JTextField();
        JLabel weightLabel = new JLabel("Weight (in kg):");
        weightField = new JTextField();

        // Create a button for BMI calculation
        JButton calculateButton = new JButton("Calculate BMI");

        // Create labels for result and category
        resultLabel = new JLabel();
        categoryLabel = new JLabel();

        // Add components to the frame
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(calculateButton);
        add(resultLabel);
        add(categoryLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    calculateBMI();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values.");
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Height and weight must be greater than zero.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
                }
            }
        });
    }

    private void calculateBMI() {
        // Get the height and weight values from the text fields
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());

        // Calculate the BMI
        double bmi = weight / ((height / 100) * (height / 100));

        // Determine the BMI category
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        // Display the result and category
        resultLabel.setText("Your BMI is: " + String.format("%.2f", bmi));
        categoryLabel.setText("Category: " + category);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	BMICalculatorGUIAnswer calculator = new BMICalculatorGUIAnswer();
                calculator.setVisible(true);
            }
        });
    }
}
