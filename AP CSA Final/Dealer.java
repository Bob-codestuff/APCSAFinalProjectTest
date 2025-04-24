import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Player {
    private ArrayList<Card> deck;

    public Dealer(String name) {
        super(name); // Call the Player constructor to set the dealer's name
        resetDeck();
    }

    public void resetDeck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < faces.length; i++) {
                deck.add(new Card(suit, faces[i], values[i]));
            }
        }
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            return null;
        }
        return deck.remove(0);
    }

    public int cardsLeft() {
        return deck.size();
    }
}