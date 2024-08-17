import javax.swing.JOptionPane;

public class NumberInputDemo {
    public static void main(String[] args) {
        // Read the first number from the user
        String input1 = JOptionPane.showInputDialog("Enter the first number:");
        int number1 = Integer.parseInt(input1);

        // Read the second number from the user
        String input2 = JOptionPane.showInputDialog("Enter the second number:");
        int number2 = Integer.parseInt(input2);

        // Perform calculations or any other desired operations
        int sum = number1 + number2;
        int difference = number1 - number2;
        int product = number1 * number2;

        // Display the results using JOptionPane
        String message = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product;
        JOptionPane.showMessageDialog(null, message);
    }
}
