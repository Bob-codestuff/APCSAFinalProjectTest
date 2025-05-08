
/**
 * The Game class implements a "Higher or Lower" card game where a player 
 * competes against a dealer. The player bets money and guesses whether 
 * the next card will be higher or lower than the current card.
 * 
 * The game manages player interactions, betting logic, and card dealing. 
 * It continues until the player chooses to exit or runs out of money. 
 * The dealer resets the deck for each new game session.
 * 
 * Key features include:
 * - Handling player bets and winnings.
 * - Managing game flow and user input.
 * - Displaying cards using ASCII art.
 * - Ensuring proper deck management.
 */
import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public Game() {
        dealer = new Dealer("Dealer"); // Initialize the dealer with the name "Dealer"
        scanner = new Scanner(System.in); // Initialize the scanner for user input
    }

    public void start() {
        System.out.println("Hello player, please enter your name:");
        String name = scanner.nextLine();
        player = new Player(name); // Initialize the player with their chosen name
        System.out.println("Welcome to Higher or Lower, " + player.getName() + "!");
        System.out.println("You are starting with $" + String.format("%.2f", player.getMoney()) + ".");
        System.out.println("You are playing against " + dealer.getName() + ".");

        boolean playing = true;
        while (playing) {
            if (player.getMoney() <= 0) {
                System.out.println("You have no more money. Game over!");
                break;
            }

            System.out.println("\nHow much would you like to bet? (You have $" + String.format("%.2f", player.getMoney()) + ")");
            double bet = 0;
            while (true) {
                try {
                    bet = Double.parseDouble(scanner.nextLine());
                    if (bet > player.getMoney()) {
                        System.out.println("You cannot bet more than you have. Try again.");
                    } else if (bet <= 0) {
                        System.out.println("You must bet a positive amount. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            player.subtractMoney(bet); // Deduct the bet amount
            System.out.println("You bet $" + String.format("%.2f", bet) + ". Let's begin!");

            Card currentCard = dealer.dealCard();
            if (currentCard == null) {
                System.out.println("The deck is empty. You win!");
                break; // Stop the program if the deck is empty
            }
            System.out.println("First card:\n" + currentCard.getAsciiArt()); // Display the card in ASCII art

            boolean continueRide = true;

            while (continueRide) {
                System.out.print("Will the next card be (h)igher or (l)ower? (or type 'exit' to leave): ");
                String guess = scanner.nextLine().toLowerCase();

                if (guess.equals("exit")) {
                    System.out.println("You chose to leave the game. Your remaining money: $" + String.format("%.2f", player.getMoney()));
                    continueRide = false;
                    break;
                }

                Card nextCard = dealer.dealCard();
                if (nextCard == null) {
                    System.out.println("No more cards left in the deck. You win!");
                    playing = false; // Stop the game
                    break;
                }

                System.out.println("Next card:\n" + nextCard.getAsciiArt()); // Display the card in ASCII art

                if ((guess.equals("h") && nextCard.getValue() >= currentCard.getValue()) ||
                    (guess.equals("l") && nextCard.getValue() <= currentCard.getValue())) {
                    bet *= 2; // Double the bet
                    System.out.println("Correct! Your bet is now $" + String.format("%.2f", bet) + ".");
                    currentCard = nextCard;
                } else {
                    System.out.println("Wrong! You lose your bet of $" + String.format("%.2f", bet) + ".");
                    bet = 0; // Reset the bet
                    continueRide = false;
                }
            }

            if (bet > 0) {
                player.addMoney(bet); // Add the winnings to the player's money
                System.out.println("You won $" + String.format("%.2f", bet) + "! Your total money is now $" + String.format("%.2f", player.getMoney()) + ".");
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("y")) {
                playing = false;
            } else {
                dealer.resetDeck(); // Reset the deck for a new game
            }
        }

        System.out.println("Thanks for playing, " + player.getName() + "! You leave with $" + String.format("%.2f", player.getMoney()) + ".");
    }
}