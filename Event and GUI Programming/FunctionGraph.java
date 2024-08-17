import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionGraph extends JFrame {
    private JTextField functionField;
    private JButton graphButton;
    private JPanel graphPanel;

    public FunctionGraph() {
        // Set up the frame
        setTitle("Function Graph");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Create the function input field
        functionField = new JTextField(20);
        inputPanel.add(new JLabel("Function: "));
        inputPanel.add(functionField);

        // Create the graph button
        graphButton = new JButton("Graph");
        inputPanel.add(graphButton);

        // Create the graph panel
        graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(graphPanel, BorderLayout.CENTER);

        // Add action listener to the graph button
        graphButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                graphPanel.repaint();
            }
        });
    }

    private void drawGraph(Graphics g) {
        // Get the width and height of the graph panel
        int width = graphPanel.getWidth();
        int height = graphPanel.getHeight();

        // Set up the coordinate system
        g.setColor(Color.BLACK);
        g.drawLine(0, height / 2, width, height / 2); // X-axis
        g.drawLine(width / 2, 0, width / 2, height); // Y-axis

        // Get the function expression from the input field
        String expression = functionField.getText();

        // Evaluate and plot the function
        for (int x = 0; x < width; x++) {
            double scaledX = (x - width / 2) / 100.0; // Scale x-coordinate to fit the graph
            double y = evaluateExpression(expression, scaledX);
            int scaledY = (int) (height / 2 - y * 100); // Scale y-coordinate to fit the graph
            g.setColor(Color.RED);
            g.fillRect(x, scaledY, 1, 1); // Plot a pixel
        }
    }

    private double evaluateExpression(String expression, double x) {
        // Implement the code to evaluate the expression here
        // You can use libraries like javax.script.ScriptEngine to evaluate mathematical expressions

        // For simplicity, this example uses a simple linear function
      //  return 2 * Math.pow(x, 3) + 1;
    	return 2*x + 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FunctionGraph graph = new FunctionGraph();
                graph.setVisible(true);
            }
        });
    }
}

