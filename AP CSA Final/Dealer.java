
/**
 * The Dealer class represents a dealer in a card game, extending the Player class.
 * It manages a deck of cards and provides functionality to deal cards, reset the deck, 
 * and check the number of cards left in the deck.
 * This class is designed to interact with the Deck and Card classes.
 */
public class Dealer extends Player {
    private Deck deck;
    private String name;

    public Dealer(String name) {
        super(name); // Use the constructor of the Player class to set the name
        this.deck = new Deck();
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name){
        super.setName(name);
    }

    public Card dealCard() {
        return deck.dealCard();
    }

    public void resetDeck() {
        deck = new Deck();
    }

    public int cardsLeft() {
        return deck.cardsLeft();
    }
}