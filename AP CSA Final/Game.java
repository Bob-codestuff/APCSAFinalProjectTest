import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public Game(String playerName) {
        player = new Player(playerName);
        dealer = new Dealer("Dealer"); // Dealer now has a name
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Ride the Train!");

        boolean playing = true;
        while (playing) {
            player.clearHand();
            System.out.println("\nDealing your first card...");
            Card currentCard = dealer.dealCard();
            player.addCard(currentCard);
            System.out.println("First card: " + currentCard);

            boolean continueRide = true;

            while (continueRide) {
                System.out.print("Will the next card be (h)igher or (l)ower? ");
                String guess = scanner.nextLine().toLowerCase();

                Card nextCard = dealer.dealCard();
                if (nextCard == null) {
                    System.out.println("No more cards left in the deck.");
                    continueRide = false;
                    break;
                }

                player.addCard(nextCard);
                System.out.println("Next card: " + nextCard);

                if ((guess.equals("h") && nextCard.getValue() > currentCard.getValue()) ||
                    (guess.equals("l") && nextCard.getValue() < currentCard.getValue())) {
                    System.out.println("Correct! Let's continue...");
                    currentCard = nextCard;
                } else {
                    System.out.println("Wrong! You lose the ride.");
                    continueRide = false;
                }
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("y")) {
                playing = false;
            } else {
                dealer.resetDeck(); // reset the deck
            }
        }

        System.out.println("Thanks for playing!");
    }
}