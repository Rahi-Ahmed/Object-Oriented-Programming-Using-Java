import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField display;
    private JPanel panel;
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        // Create the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setResizable(false); // Make the frame size fixed

        // Create the display field
        display = new JTextField(10);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        // Create the panel with GridBagLayout
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Display setup
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4; // Span across 4 columns
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(display, gbc);

        // Button labels
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "sqrt", "^", "%"
        };

        // Add buttons to the panel
        int x = 0, y = 1;
        for (String label : buttonLabels) {
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = x;
            gbc.gridy = y;
            gbc.gridwidth = 1;

            JButton button = new JButton(label);
            button.setPreferredSize(new Dimension(80, 80));
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button, gbc);

            x++;
            if (x % 4 == 0) {
                x = 0;
                y++;
            }
        }

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Action listener for button clicks
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "C": // Clear the display
                    display.setText("");
                    break;
                case "=": // Calculate the result
                    num2 = Double.parseDouble(display.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            result = num1 / num2;
                            break;
                        case '^':
                            result = Math.pow(num1, num2);
                            break;
                        case '%':
                            result = num1 % num2;
                            break;
                    }
                    display.setText(String.valueOf(result));
                    break;
                case "sqrt": // Calculate the square root
                    num1 = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(Math.sqrt(num1)));
                    break;
                default: // Handle number and operator inputs
                    if ("+-*/%^".contains(command)) {
                        num1 = Double.parseDouble(display.getText());
                        operator = command.charAt(0);
                        display.setText("");
                    } else {
                        display.setText(display.getText() + command);
                    }
                    break;
            }
        }
    }

    // Main method to start the calculator
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
