import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingComponentsExample {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Components Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));  // Using GridLayout for a simple layout

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
                textArea.append("Button clicked!\n");
            }
        });
        panel.add(button);

        // JCheckBox
        JCheckBox checkBox = new JCheckBox("Check me");
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Checkbox is " + (checkBox.isSelected() ? "selected" : "not selected") + "\n");
            }
        });
        panel.add(checkBox);

        // JRadioButton
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        panel.add(radioButton1);
        panel.add(radioButton2);

        // ActionListener for Radio Buttons
        ActionListener radioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                textArea.append("Radio Button selected: " + source.getText() + "\n");
            }
        };
        radioButton1.addActionListener(radioListener);
        radioButton2.addActionListener(radioListener);

        // JComboBox
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("ComboBox selected: " + comboBox.getSelectedItem() + "\n");
            }
        });
        panel.add(comboBox);

        // JSlider
        JSlider slider = new JSlider(0, 100, 50);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                textArea.append("Slider value: " + slider.getValue() + "\n");
            }
        });
        panel.add(slider);

        // JProgressBar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        panel.add(progressBar);

        // JButton to simulate progress
        JButton progressButton = new JButton("Increase Progress");
        progressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int currentValue = progressBar.getValue();
                if (currentValue < 100) {
                    progressBar.setValue(currentValue + 10);
                    textArea.append("ProgressBar value: " + progressBar.getValue() + "\n");
                } else {
                    textArea.append("ProgressBar is already full!\n");
                }
            }
        });
        panel.add(progressButton);

        // JList with JScrollPane
        String[] listItems = {"Item 1", "Item 2", "Item 3"};
        JList<String> list = new JList<>(listItems);
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                textArea.append("List item selected: " + list.getSelectedValue() + "\n");
            }
        });
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
                textArea.append("Tool button clicked!\n");
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
