import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", 
            "Jack", "Queen", "King", "Ace"
        };

        for (int x = 0; x < suits.length; x++) {
            for (int i = 0; i < faces.length; i++) {
                cards.add(new Card(suits[x], faces[i], i + 2));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) { // Start from the end of the list
            int j = random.nextInt(i + 1); // Generate a random index between 0 and i
            // Swap cards[i] and cards[j]
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public String dealCard() {
        if (cards.size() > 0) { 
            return cards.remove(0).toString(); // Convert Card to String
        }
        return null;
    }

    public int size() {
        return cards.size();
    }
}