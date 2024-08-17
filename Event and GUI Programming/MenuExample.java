import java.awt.*;
import java.awt.event.*;

public class MenuExample extends Frame {
    private Dialog dialogue;

    public MenuExample() {
        setTitle("Menu Example");

        // Create the menu bar
        MenuBar menuBar = new MenuBar();

        // Create the "File" menu
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");

        // Create the "Help" menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");

        // Add menu items to the "File" menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Add a separator line
        fileMenu.add(exitItem);

        // Add menu items to the "Help" menu
        helpMenu.add(aboutItem);

        // Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Set the menu bar for the frame
        setMenuBar(menuBar);

        // Add event listeners for menu item clicks
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a dialogue box for "Open" option
                showDialogue("Open", "File Opened");
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a dialogue box for "Save" option
                showDialogue("Save", "File Saved");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exit the program when "Exit" is clicked
                System.exit(0);
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display a dialogue box for "About" option
                showDialogue("About", "Menu Example Application");
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    private void showDialogue(String title, String message) {
        // Create a dialogue box with the given title and message
        dialogue = new Dialog(this, title, true);
        dialogue.setLayout(new FlowLayout());
        dialogue.add(new Label(message));

        // Add a window listener to the dialogue box to handle the close button
        dialogue.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dialogue.dispose(); // Close the dialogue box
            }
        });

        dialogue.pack();
        dialogue.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
