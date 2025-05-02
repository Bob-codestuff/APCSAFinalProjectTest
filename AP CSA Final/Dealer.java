public class Dealer extends Player {
    private Deck deck;

    public Dealer(String name) {
        super(name); // Use the constructor of the Player class to set the name
        this.deck = new Deck();
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