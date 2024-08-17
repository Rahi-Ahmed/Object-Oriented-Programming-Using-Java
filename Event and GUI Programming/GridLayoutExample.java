import java.awt.*;
import java.awt.event.*;

public class GridLayoutExample extends Frame {
    public GridLayoutExample() {
        // Set up the frame
        setTitle("GridLayout Example");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2)); // Set GridLayout with 3 rows and 2 columns
        
        // Add buttons to the frame
        add(new Button("Button 1"));
        add(new Button("Button 2"));
        add(new Button("Button 3"));
        add(new Button("Button 4"));
        add(new Button("Button 5"));
        add(new Button("Button 6"));
        
        // Add window listener for close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        GridLayoutExample example = new GridLayoutExample();
        example.setVisible(true);
    }
}
