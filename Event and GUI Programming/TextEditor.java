import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor extends JFrame {
    private JTextArea textArea;  // The text area component for entering and editing text
    private JFileChooser fileChooser;  // File chooser component for selecting file save location

    public TextEditor() {
        setTitle("Text Editor");  // Set the title of the text editor window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set the close operation
        setSize(500, 400);  // Set the size of the text editor window

        textArea = new JTextArea();  // Create a new JTextArea for text input
        JScrollPane scrollPane = new JScrollPane(textArea);  // Add scroll bars to the text area
        add(scrollPane, BorderLayout.CENTER);  // Add the scroll pane to the center of the frame

        JMenuBar menuBar = new JMenuBar();  // Create a new menu bar
        JMenu fileMenu = new JMenu("File");  // Create a new "File" menu
        JMenuItem saveMenuItem = new JMenuItem("Save");  // Create a new "Save" menu item
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();  // Call the saveToFile() method when the "Save" menu item is clicked
            }
        });
        fileMenu.add(saveMenuItem);  // Add the "Save" menu item to the "File" menu
        menuBar.add(fileMenu);  // Add the "File" menu to the menu bar
        setJMenuBar(menuBar);  // Set the menu bar for the frame

        fileChooser = new JFileChooser();  // Create a new file chooser

        setVisible(true);  // Make the frame visible
    }

    private void saveToFile() {
        int returnVal = fileChooser.showSaveDialog(this);  // Show the file save dialog
        if (returnVal == JFileChooser.APPROVE_OPTION) {  // If the user selects a file and clicks "Save"
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();  // Get the selected file path
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));  // Create a writer for the file
                writer.write(textArea.getText());  // Write the text area content to the file
                writer.close();  // Close the writer
                JOptionPane.showMessageDialog(this, "File saved successfully.");  // Show a success message
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());  // Show an error message if an exception occurs
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextEditor();  // Create a new instance of the TextEditor class
            }
        });
    }
}
