import java.awt.*;
import java.awt.event.*;

public class BorderLayoutExample extends Frame {
    public BorderLayoutExample() {
        // Set up the frame
        setTitle("BorderLayout Example");
        setSize(400, 200);
        setLayout(new BorderLayout()); // Set BorderLayout as the layout manager
        
        // Add buttons to the frame in different regions
        add(new Button("North"), BorderLayout.NORTH);
        add(new Button("South"), BorderLayout.SOUTH);
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
        add(new Button("Center"), BorderLayout.CENTER);
        
        // Add window listener for close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        BorderLayoutExample example = new BorderLayoutExample();
        example.setVisible(true);
    }
}
