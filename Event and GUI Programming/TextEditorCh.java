import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditorCh extends JFrame {
    private JTextArea textArea;  // Text area to display and edit the text
    private JFileChooser fileChooser;  // File chooser dialog for opening and saving files

    public TextEditorCh() {
        // Set up the frame
        setTitle("Text Editor");  // Set the title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set the default close operation
        setSize(500, 500);  // Set the size of the frame

        // Create the text area
        textArea = new JTextArea();  // Create a new text area
        JScrollPane scrollPane = new JScrollPane(textArea);  // Add the text area to a scroll pane for scrolling
        add(scrollPane, BorderLayout.CENTER);  // Add the scroll pane to the center of the frame

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();  // Create a new menu bar
        JMenu fileMenu = new JMenu("File");  // Create a new menu
        JMenuItem openMenuItem = new JMenuItem("Open");  // Create a new menu item for opening a file
        JMenuItem saveMenuItem = new JMenuItem("Save");  // Create a new menu item for saving a file
        fileMenu.add(openMenuItem);  // Add the open menu item to the file menu
        fileMenu.add(saveMenuItem);  // Add the save menu item to the file menu
        menuBar.add(fileMenu);  // Add the file menu to the menu bar
        setJMenuBar(menuBar);  // Set the menu bar for the frame

        // Create the file chooser
        fileChooser = new JFileChooser();  // Create a new file chooser dialog

        // Add action listeners to the menu items
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();  // Call the openFile() method when the open menu item is clicked
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();  // Call the saveFile() method when the save menu item is clicked
            }
        });
    }

    // Method to handle opening a file
    private void openFile() {
        int returnVal = fileChooser.showOpenDialog(this);  // Show the open file dialog and get the return value
        if (returnVal == JFileChooser.APPROVE_OPTION) {  // If the user chooses a file
            try {
                File selectedFile = fileChooser.getSelectedFile();  // Get the selected file
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));  // Create a reader for the file
                StringBuilder content = new StringBuilder();  // Create a string builder to store the file content
                String line;
                while ((line = reader.readLine()) != null) {  // Read each line of the file
                    content.append(line).append("\n");  // Append the line to the content with a new line character
                }
                reader.close();  // Close the reader
                textArea.setText(content.toString());  // Set the text area content to the file content
                JOptionPane.showMessageDialog(this, "File opened successfully.");  // Show a success message
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());  // Show an error message
            }
        }
    }

    // Method to handle saving a file
    private void saveFile() {
        int returnVal = fileChooser.showSaveDialog(this);  // Show the save file dialog and get the return value
        if (returnVal == JFileChooser.APPROVE_OPTION) {  // If the user chooses a file
            try {
                File selectedFile = fileChooser.getSelectedFile();  // Get the selected file
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));  // Create a writer for the file
                writer.write(textArea.getText());  // Write the text area content to the file
                writer.close();  // Close the writer
                JOptionPane.showMessageDialog(this, "File saved successfully.");  // Show a success message
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());  // Show an error message
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextEditorCh editor = new TextEditorCh();  // Create a new instance of the TextEditor class
                editor.setVisible(true);  // Set the editor frame to be visible
            }
        });
    }
}

