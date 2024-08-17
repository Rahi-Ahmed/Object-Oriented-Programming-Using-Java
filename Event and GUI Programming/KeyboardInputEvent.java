import java.awt.*;
import java.awt.event.*;

public class KeyboardInputEvent {
    public static void main(String[] args) {
        // Create a frame (window) object
        Frame frame = new Frame("Keyboard Input Event");

        // Create a label object
        Label label = new Label();

        // Add key listener using anonymous inner class
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + e.getKeyChar());
            }
        });

        // Add the label to the frame
        frame.add(label, BorderLayout.CENTER);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Make the frame visible
        frame.setVisible(true);

        // Set the focus on the frame to receive keyboard events
        frame.setFocusable(true);
        frame.requestFocus();
        
        // Add window listener using anonymous inner class
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
