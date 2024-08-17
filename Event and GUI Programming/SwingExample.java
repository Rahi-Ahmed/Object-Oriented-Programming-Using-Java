import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingExample extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1, menuItem2;
    private JTextField textField;

    public SwingExample() {
        // Set up the frame
        setTitle("Swing Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // Create a text field
        textField = new JTextField(20);
        add(textField);
        
        // Create a menu bar
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        menuItem1 = new JMenuItem("Option 1");
        menuItem2 = new JMenuItem("Option 2");
        
        // Add action listeners to menu items
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        
        // Add menu items to the menu
        menu.add(menuItem1);
        menu.add(menuItem2);
        
        // Add menu to the menu bar
        menuBar.add(menu);
        
        // Set the menu bar to the frame
        setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String command = ae.getActionCommand();
            if (command.equals("Option 1")) {
                textField.setText("Option 1 selected");
            } else if (command.equals("Option 2")) {
                textField.setText("Option 2 selected");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingExample example = new SwingExample();
        example.setVisible(true);
    }
}
