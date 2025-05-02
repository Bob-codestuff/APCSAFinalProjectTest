public class Card {
    private String suit;
    private String face;
    private int value;

    public Card(String suit, String face, int value) {
        this.suit = suit;
        this.face = face;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    public int getValue() {
        return value;
    }

    public String getAsciiArt() {

        String abbreviatedFace = face;
        if (face.equalsIgnoreCase("King")) {
            abbreviatedFace = "K";
        } else if (face.equalsIgnoreCase("Queen")) {
            abbreviatedFace = "Q";
        } else if (face.equalsIgnoreCase("Jack")) {
            abbreviatedFace = "J";
        } else if (face.equalsIgnoreCase("Ace")) {
            abbreviatedFace = "A";
        }

        // Map suits to custom symbols
        String[] suitSymbol = {"?", "?", "?"};
    
        if (suit.equalsIgnoreCase("Hearts")) {
            suitSymbol = new String[]{
                "|    _ _   |",
                "|   ( v )  |",
                "|    \\ /   |",
                "|     .    |"
            };
        } else if (suit.equalsIgnoreCase("Diamonds")) {
            suitSymbol = new String[]{
                "|    /\\    |",
                "|   /  \\   |",
                "|   \\  /   |",
                "|    \\/    |"
            };
        } else if (suit.equalsIgnoreCase("Clubs")) {
            suitSymbol = new String[]{
                "|     _    |",
                "|    ( )   |",
                "|   (_ _)  |",
                "|     Y    |"
            };
        } else if (suit.equalsIgnoreCase("Spades")) {
            suitSymbol = new String[]{
                "|    /\\    |",
                "|   /  \\   |",
                "|   \\__/   |",
                "|    ||    |"
            };
        }
    
        // Build the ASCII art for the card
        StringBuilder asciiArt = new StringBuilder();
        asciiArt.append(" *----------*\n");
        asciiArt.append(String.format(" |%s         |\n", abbreviatedFace)); // Top row with abbreviated face
        for (String row : suitSymbol) {
            asciiArt.append(String.format(" %s\n", row)); // Add each row of the suit symbol
        }
        asciiArt.append(String.format(" |         %s|\n", abbreviatedFace)); // Bottom row with abbreviated face
        asciiArt.append(" *----------*\n"); // Bottom border with stars
        return asciiArt.toString();
    }
}