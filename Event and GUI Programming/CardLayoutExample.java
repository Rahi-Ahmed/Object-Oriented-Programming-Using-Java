import java.awt.*;
import java.awt.event.*;

public class CardLayoutExample extends Frame implements ActionListener {
    private CardLayout cardLayout;
    private Panel cardPanel;
    private Button nextButton;

    public CardLayoutExample() {
        // Set up the frame
        setTitle("CardLayout Example");
        setSize(400, 200);
        cardLayout = new CardLayout();
        cardPanel = new Panel();
        cardPanel.setLayout(cardLayout); // Set CardLayout as the layout manager for the panel
        
        // Create panels for different cards
        Panel card1 = new Panel();
        card1.add(new Label("This is Card 1"));
        card1.setBackground(Color.CYAN);
        
        Panel card2 = new Panel();
        card2.add(new Label("This is Card 2"));
        card2.setBackground(Color.GREEN);
        
        Panel card3 = new Panel();
        card3.add(new Label("This is Card 3"));
        card3.setBackground(Color.YELLOW);
        
        // Add cards to the card panel
        cardPanel.add(card1, "Card 1");
        cardPanel.add(card2, "Card 2");
        cardPanel.add(card3, "Card 3");
        
        // Add the card panel to the frame
        add(cardPanel, BorderLayout.CENTER);
        
        // Create a button to switch cards
        nextButton = new Button("Next");
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);
        
        // Add window listener for close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            cardLayout.next(cardPanel); // Show the next card
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CardLayoutExample example = new CardLayoutExample();
        example.setVisible(true);
    }
}
