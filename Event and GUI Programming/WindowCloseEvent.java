import java.awt.*;
import java.awt.event.*;

public class WindowCloseEvent {
    public static void main(String[] args) {
        // Create a frame (window) object
        Frame frame = new Frame("Window Close Event");

        // Add window listener using anonymous inner class
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Set the size of the frame
        frame.setSize(400, 300);

        // Make the frame visible
        frame.setVisible(true);
    }
}
