import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    
        
        System.out.println("Welcome to the Card Game!");
        Scanner scanner = new Scanner(System.in);

        // Get the player's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Initialize the deck and player's hand
        Deck deck = new Deck();
        ArrayList<String> playerHand = new ArrayList<>();

        // Main game loop
        boolean playing = true;
        while (playing) {
            System.out.println("\nHello " + playerName + "! What would you like to do?");
            System.out.println("1. Draw a card");
            System.out.println("2. View your hand");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Draw a card from the deck
                String card = deck.dealCard();
                if (card != null) {
                    playerHand.add(card);
                    System.out.println("You drew: " + card);
                } else {
                    System.out.println("The deck is empty! No more cards to draw.");
                }
            } else if (choice == 2) {
                // View the player's hand
                if (playerHand.size() == 0) { 
                    System.out.println("Your hand is empty.");
                } else {
                    System.out.println("Your hand: " + playerHand);
                }
            } else if (choice == 3) {
                // Exit the game
                System.out.println("Thanks for playing, " + playerName + "!");
                playing = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}