public class Card {
    private String suit;
    private String face;
    private int value;

    public Card(String suit, String face, int value) {
        this.suit = suit;
        this.face = face;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}