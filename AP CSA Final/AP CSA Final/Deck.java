/**
 * The Deck class represents a standard deck of playing cards.
 * It provides functionality to initialize the deck with 52 cards,
 * shuffle the deck, deal a card, and check the number of cards left in the deck.
 * 
 * The deck consists of cards with four suits ("Hearts", "Diamonds", "Clubs", "Spades"),
 * thirteen faces ("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"),
 * and corresponding values (2 through 14).
 * 
 * This class uses an ArrayList to store the cards and provides methods to manipulate the deck.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < faces.length; i++) {
                cards.add(new Card(suit, faces[i], values[i]));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public int cardsLeft() {
        return cards.size();
    }
}