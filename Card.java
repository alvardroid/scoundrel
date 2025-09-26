public class Card {
    private int value;
    private char suit; // 'S -> ♠', H -> '♥', D -> '♦', C -> '♣'
    private CardType type;

    public Card (int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public void showCard() {
        String v;
        switch (value) {
            case 11 -> v = "J";
            case 12 -> v = "Q";
            case 13 -> v = "K";
            case 14 -> v = "A";
            default -> v = String.valueOf(value);
        }

        switch (type) {
            case ENEMY -> Utils.colorPrint(ColorType.RED, v + suit);
            case HEAL ->  Utils.colorPrint(ColorType.LIME, v + suit);
            case WEAPON -> Utils.colorPrint(ColorType.YELLOW, v + suit);
        }
    }

    public int getValue() {
        return this.value;
    }

    public char getSuit() {
        return this.suit;
    }

    public CardType getType() {
        return this.type;
    }

    public void setType(CardType type) {
        this.type = type;
    }
}
