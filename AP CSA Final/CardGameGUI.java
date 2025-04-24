import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class CardGameGUI {
    private Deck deck;
    private ArrayList<String> playerHand;
    private JLabel cardImageLabel;

    public CardGameGUI() {
        deck = new Deck(); // Use your existing Deck class
        playerHand = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton drawButton = new JButton("Draw Card");
        JButton viewHandButton = new JButton("View Hand");
        buttonPanel.add(drawButton);
        buttonPanel.add(viewHandButton);

        // Create a text area to display messages
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        // Create a label to display the card image
        cardImageLabel = new JLabel();
        cardImageLabel.setHorizontalAlignment(JLabel.CENTER);
        cardImageLabel.setVerticalAlignment(JLabel.CENTER);

        // Add components to the frame
        frame.add(new JScrollPane(messageArea), BorderLayout.SOUTH);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(cardImageLabel, BorderLayout.CENTER);

        // Add action listeners for buttons
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String card = deck.dealCard();
                if (card != null) {
                    playerHand.add(card);
                    messageArea.append("You drew: " + card + "\n");
                    updateCardImage(card);
                } else {
                    messageArea.append("The deck is empty! No more cards to draw.\n");
                }
            }
        });

        viewHandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerHand.isEmpty()) {
                    messageArea.append("Your hand is empty.\n");
                } else {
                    messageArea.append("Your hand: " + playerHand + "\n");
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
    
    private void updateCardImage(String card) {
        // Convert the card name to a file name (e.g., "Ace of Spades" -> "Ace_of_Spades.png")
        String fileName = card.replace(" ", "_") + ".png";
        String filePath = "images/" + fileName; // Adjust the path to your images folder

        // Load the image and set it to the label
        ImageIcon cardImage = new ImageIcon(filePath);
        cardImageLabel.setIcon(cardImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CardGameGUI());
    }
}