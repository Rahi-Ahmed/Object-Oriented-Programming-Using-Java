import java.awt.*;
import java.awt.event.*;

public class FlowLayoutExample extends Frame {
    public FlowLayoutExample() {
        // Set up the frame
        setTitle("FlowLayout Example");
        setSize(400, 200);
        setLayout(new FlowLayout()); // Set FlowLayout as the layout manager
        
        // Add buttons to the frame
        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
        add(new Button("Button 5"));
        
        // Add window listener for close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        FlowLayoutExample example = new FlowLayoutExample();
        example.setVisible(true);
    }
}
