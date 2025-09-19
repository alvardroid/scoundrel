public class Card {
    private int value;
    private CardType type;

    public Card (int value, CardType type) {
        this.value = value;
        this.type = type;
    }

    public void showCard() {
        String v;
        switch (value) {
            case 11:
                v = "J";
                break;
            case 12:
                v = "Q";
                break;
            case 13:
                v = "K";
                break;
            case 14:
                v = "A";
                break;
            default:
                v = String.valueOf(value);
                break;
        }

        switch (type) {
            case ENEMY:
                Utils.colorPrint(ColorType.RED, v);
                break;
            case HEAL:
                Utils.colorPrint(ColorType.LIME, v);
                break;
            case WEAPON:
                Utils.colorPrint(ColorType.YELLOW, v);
                break;
        }
    }
}
