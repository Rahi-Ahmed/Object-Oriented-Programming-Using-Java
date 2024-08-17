import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingComponentsDemo {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Components Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // JLabel
        JLabel label = new JLabel("This is a JLabel");
        panel.add(label);
        
        // JTextField
        JTextField textField = new JTextField("Enter text here");
        panel.add(textField);
        
        // JTextArea with JScrollPane
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        
        // JButton
        JButton button = new JButton("Click Me");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button clicked!");
            }
        });
        panel.add(button);
        
        // JCheckBox
        JCheckBox checkBox = new JCheckBox("Check me");
        panel.add(checkBox);
        
        // JRadioButton
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        panel.add(radioButton1);
        panel.add(radioButton2);
        
        // JComboBox
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panel.add(comboBox);
        
        // JSlider
        JSlider slider = new JSlider(0, 100, 50);
        panel.add(slider);
        
        // JProgressBar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        panel.add(progressBar);
        
        // JList with JScrollPane
        String[] listItems = {"Item 1", "Item 2", "Item 3"};
        JList<String> list = new JList<>(listItems);
        JScrollPane listScrollPane = new JScrollPane(list);
        panel.add(listScrollPane);
        
        // JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab 1", new JLabel("Content for Tab 1"));
        tabbedPane.addTab("Tab 2", new JLabel("Content for Tab 2"));
        panel.add(tabbedPane);
        
        // JMenuBar and JMenu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        
        // JToolBar
        JToolBar toolBar = new JToolBar();
        JButton toolBarButton = new JButton("Tool Button");
        toolBarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Tool button clicked!");
            }
        });
        toolBar.add(toolBarButton);
        frame.add(toolBar, BorderLayout.PAGE_START);
        
        // Adding the panel to the frame
        frame.add(panel);
        
        // Display the frame
        frame.setVisible(true);
    }
}
