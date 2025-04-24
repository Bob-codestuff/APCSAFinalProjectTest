import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CardGameGUI {
    private Dealer dealer;
    private Player player;
    private JTextArea cardDisplayArea;
    private JTextArea handDisplayArea;
    private JTextArea dealerDisplayArea;

    public CardGameGUI() {
        initializeGame();
        createAndShowGUI();
    }

    private void initializeGame() {
        // Prompt the user for their name
        String playerName = JOptionPane.showInputDialog(null, "Enter your name:", "Player Name", JOptionPane.PLAIN_MESSAGE);
        if (playerName == null || playerName.trim().isEmpty()) {
            playerName = "Player";
        }

        // Initialize the player and dealer
        player = new Player(playerName);
        dealer = new Dealer("Dealer");
    }

    private void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Ride the Train");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton drawButton = new JButton("Draw Card");
        JButton viewHandButton = new JButton("View Hand");
        JButton viewDealerButton = new JButton("View Dealer");
        buttonPanel.add(drawButton);
        buttonPanel.add(viewHandButton);
        buttonPanel.add(viewDealerButton);

        // Create a text area to display the current card
        cardDisplayArea = new JTextArea(10, 20);
        cardDisplayArea.setEditable(false);
        cardDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Create a text area to display the player's hand
        handDisplayArea = new JTextArea(10, 20);
        handDisplayArea.setEditable(false);
        handDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Create a text area to display the dealer's information
        dealerDisplayArea = new JTextArea(10, 20);
        dealerDisplayArea.setEditable(false);
        dealerDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Add components to the frame
        frame.add(new JScrollPane(cardDisplayArea), BorderLayout.CENTER);
        frame.add(new JScrollPane(handDisplayArea), BorderLayout.EAST);
        frame.add(new JScrollPane(dealerDisplayArea), BorderLayout.WEST);
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Add action listeners for buttons
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card card = dealer.dealCard();
                if (card != null) {
                    player.addCard(card);
                    displayCardASCII(card);
                    handDisplayArea.setText(""); // Clear the hand display area
                } else {
                    cardDisplayArea.setText("The deck is empty! No more cards to draw.");
                }
            }
        });

        viewHandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayHandASCII();
            }
        });

        viewDealerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDealerInfo();
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    private void displayCardASCII(Card card) {
        // Generate ASCII art for the card
        String asciiCard = generateCardASCII(card);
        cardDisplayArea.setText(asciiCard); // Show the current card
    }

    private void displayHandASCII() {
        // Generate ASCII art for all cards in the player's hand
        StringBuilder handASCII = new StringBuilder();
        for (Card card : player.getHand()) {
            handASCII.append(generateCardASCII(card)).append("\n\n");
        }
        handDisplayArea.setText(handASCII.toString()); // Show the entire hand
    }

    private void displayDealerInfo() {
        // Display the dealer's name and remaining cards
        StringBuilder dealerInfo = new StringBuilder();
        dealerInfo.append("Dealer Name: ").append(dealer.getName()).append("\n");
        dealerInfo.append("Cards Left in Deck: ").append(dealer.cardsLeft()).append("\n");
        dealerDisplayArea.setText(dealerInfo.toString());
    }

    private String generateCardASCII(Card card) {
        // Get the face and suit of the card
        String face = card.getFace();
        String suit = card.getSuit();

        // Map suits to symbols
        String suitSymbol = switch (suit) {
            case "Hearts" -> "♥";
            case "Diamonds" -> "♦";
            case "Clubs" -> "♣";
            case "Spades" -> "♠";
            default -> "?";
        };

        // Create the ASCII art
        String topBottomBorder = "+-----------+";
        String emptyLine = "|           |";
        String faceLine = String.format("| %-9s |", face);
        String suitLine = String.format("|     %s     |", suitSymbol);

        return String.join("\n",
            topBottomBorder,
            faceLine,
            emptyLine,
            suitLine,
            emptyLine,
            faceLine,
            topBottomBorder
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CardGameGUI());
    }
}