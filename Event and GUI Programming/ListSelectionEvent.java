import java.awt.*;
import java.awt.event.*;

public class ListSelectionEvent {
    public static void main(String[] args) {
        // Create a frame (window) object
        Frame frame = new Frame("List Selection Event");

        // Create a list object
        List list = new List();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        // Create a label object
        Label label = new Label();

        // Add item listener using anonymous inner class
        list.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("Selected Item: " + list.getSelectedItem());
            }
        });

        // Add the list and label to the frame
        frame.add(list, BorderLayout.CENTER);
        frame.add(label, BorderLayout.NORTH);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Make the frame visible
        frame.setVisible(true);
        
        // Add window listener using anonymous inner class
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
