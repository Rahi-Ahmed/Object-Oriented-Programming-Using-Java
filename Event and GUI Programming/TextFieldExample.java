import java.awt.*;

public class TextFieldExample {

	public static void main(String[] args) {
		  // Create a frame (window) object
        Frame frame = new Frame("TextField Example");
        
        //Create a text field object
        TextField textField = new TextField();
        
        //Add it to the frame
        frame.add(textField);
        
     // Set the size of the frame
        frame.setSize(400, 300);
        
        // Make the frame visible
        frame.setVisible(true);

	}

}
