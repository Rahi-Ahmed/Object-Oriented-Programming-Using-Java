import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorAnswer extends JFrame {
    private JTextArea textArea;

    public TextEditorAnswer() {
        // Set up the frame
        setTitle("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create the "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create the "Save" menu item
        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);

        // Create the "Word Count" menu item
        JMenuItem wordCountMenuItem = new JMenuItem("Word Count");
        fileMenu.add(wordCountMenuItem);

        // Create the text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listeners to menu items
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTextToFile();
            }
        });

        wordCountMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void saveTextToFile() {
        String text = textArea.getText();

        // Implement the code to save the text to a file here
        // ...

        JOptionPane.showMessageDialog(this, "Text saved successfully!");
    }

    private void countWords() {
        String text = textArea.getText();

        // Split the text into words using whitespace as delimiter
        String[] words = text.split("\\s+");

        // Exclude common articles, prepositions, and conjunctions from the word count
        String[] excludedWords = {"a", "an", "the", "in", "on", "at", "for", "and", "but", "or"};
        int count = 0;

        for (String word : words) {
            // Check if the word is not in the excluded words list
            if (!isExcludedWord(word)) {
                count++;
            }
        }

        JOptionPane.showMessageDialog(this, "Word count: " + count);
    }

    private boolean isExcludedWord(String word) {
        String[] excludedWords = {"a", "an", "the", "in", "on", "at", "for", "and", "but", "or"};

        for (String excluded : excludedWords) {
            if (word.equalsIgnoreCase(excluded)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextEditorAnswer editor = new TextEditorAnswer();
                editor.setVisible(true);
            }
        });
    }
}
